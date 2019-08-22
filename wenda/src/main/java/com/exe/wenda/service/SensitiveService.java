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
 * 字典树（前缀树）
 *
 * @Date 2019/4/4 20:48
 */
@Service
public class SensitiveService implements InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(SensitiveService.class);

    //替换词
    private static final String DEFAULT_REPLACEMENT = "***";

    //构建Tire树
    private class TrieNode {
        //判断是不是最后一个节点
        private boolean end = false;

        //创建子树
        private Map<Character, TrieNode> subNodes = new HashMap<Character, TrieNode>();

        //指定位置添加节点
        private void addSubNode(Character key, TrieNode node) {
            subNodes.put(key, node);
        }

        //获取下一个节点
        private TrieNode getSubNode(Character key) {
            return subNodes.get(key);
        }

        //判断是否为叶子节点
        private boolean isKeyWordEnd() {
            return end;
        }

        //设置叶子节点
        private void setKeyWordEnd(boolean end) {
            this.end = end;
        }

        public int getSubNodeCount() {
            return subNodes.size();
        }
    }

    //根节点，空节点
    private TrieNode root = new TrieNode();

    //判断是否是一个符号：比如空格、符号、颜文字等等
    private boolean isSymbol(char c) {
        int ic = (int) c;
        //东亚文字：0x2E80 ~ 0x9FFF
        return !CharUtils.isAsciiAlphanumeric(c) && (ic < 0x2E80 || ic > 0x9FFF);
    }

    //过滤敏感词
    public String filter(String text) {
        if (StringUtils.isBlank(text)) {
            return text;
        }
        String replacement = DEFAULT_REPLACEMENT;
        StringBuilder result = new StringBuilder();

        //临时节点指向根节点
        TrieNode tempNode = root;
        int begin = 0;//回滚数
        int position = 0;//当前比较的位置，它走完就说明判断完了

        //position还没有走到结尾
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
            } else if (tempNode.isKeyWordEnd()) {//发现敏感词
                result.append(replacement);
                position = position + 1;
                begin = position;
                tempNode = root;
            } else {//tempNode往后走，position也跟着
                ++position;
            }
        }

        result.append(text.substring(begin));
        return result.toString();
    }

    //添加新的敏感词
    private void addWord(String lineTxt) {
        TrieNode tempNode = root;
        //遍历每个节点
        for (int i = 0; i < lineTxt.length(); i++) {
            Character c = lineTxt.charAt(i);
            if (isSymbol(c)) {
                continue;
            }
            TrieNode node = tempNode.getSubNode(c);
            //如果为空，说明当前节点下面没有节点
            if (node == null) {
                //新建一个节点
                node = new TrieNode();
                tempNode.addSubNode(c, node);
            }

            tempNode = node;

            //如果是最后一个字符，那么标记为最后一个节点
            if (i == lineTxt.length() - 1) {
                tempNode.setKeyWordEnd(true);
            }
        }
    }

    //初始化文件中的敏感词
    public void afterPropertiesSet() throws Exception {
        root = new TrieNode();
        try {
            //IO流读取文本文件中的敏感词
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
