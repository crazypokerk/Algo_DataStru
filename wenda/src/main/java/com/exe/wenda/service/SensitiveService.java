package com.exe.wenda.service;

import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * ***********************************************重点
 *
 * @Date 2019/4/4 20:48
 */
@Service
public class SensitiveService implements InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(SensitiveService.class);

    private static final String DEAFULT_REPLACEMENT = "xxx";


    //构建Tire树
    private class TrieNode {
        //判断是不是最后一个节点
        private boolean end = false;

        private Map<Character, TrieNode> subNodes = new HashMap<>();

        //指定位置添加节点
        void addSubNode(Character key, TrieNode node) {
            subNodes.put(key, node);
        }

        //获取下一个节点
        private TrieNode getSubNode(Character key) {
            return subNodes.get(key);
        }

        boolean isKeyWordEnd() {
            return end;
        }

        void setKeyWordEnd(boolean end) {
            this.end = end;
        }

        public int getSubNodeCount() {
            return subNodes.size();
        }
    }

    //根节点
    private TrieNode root = new TrieNode();

    //判断是否是一个符号
    private boolean isSymbol(char c) {
        int ic = (int) c;
        return !CharUtils.isAsciiAlphanumeric(c) && (ic < 0x2E80 || ic > 0x9FFF);
    }

    //过滤敏感词
    public String filter(String text) {
        if (StringUtils.isBlank(text)) {
            return text;
        }
        String replacement = DEAFULT_REPLACEMENT;
        StringBuilder result = new StringBuilder();

        TrieNode tempNode = root;
        int begin = 0;//回滚数
        int position = 0;//当前比较的位置

        while (position < text.length()) {
            char c = text.charAt(position);
            if (isSymbol(c)) {
                if (tempNode == root) {
                    result.append(c);
                    ++begin;
                }
                ++position;
                continue;
            }

            tempNode = tempNode.getSubNode(c);

            if (tempNode == null) {
                result.append(text.charAt(begin));
                position = begin + 1;
                begin = position;
                tempNode = root;
            } else if (tempNode.isKeyWordEnd()) {
                result.append(replacement);
                position = position + 1;
                begin = position;
                tempNode = root;
            } else {
                ++position;
            }
        }

        result.append(text.substring(begin));
        return result.toString();
    }

    //添加新的敏感词
    private void addWord(String lineTxt) {
        TrieNode tempNode = root;
        for (int i = 0; i < lineTxt.length(); i++) {
            Character c = lineTxt.charAt(i);
            if (isSymbol(c)) {
                continue;
            }
            TrieNode node = tempNode.getSubNode(c);
            if (node == null) {
                node = new TrieNode();
                tempNode.addSubNode(c, node);
            }

            tempNode = node;

            if (i == lineTxt.length() - 1) {
                tempNode.setKeyWordEnd(true);
            }
        }
    }

    //初始化文件中的敏感词
    @Override
    public void afterPropertiesSet() throws Exception {
        root = new TrieNode();
        try {
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("sensitiveWords.txt");
            InputStreamReader read = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(read);

            String lineTxt;
            while ((lineTxt = br.readLine()) != null) {
                lineTxt = lineTxt.trim();
                addWord(lineTxt);
            }
            read.close();
        } catch (Exception e) {
            logger.error("读取敏感词文件失败！" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SensitiveService s = new SensitiveService();
        s.addWord("打炮");
        s.addWord("大保健");
        System.out.println(s.filter("大✿▽保健"));
    }
}
