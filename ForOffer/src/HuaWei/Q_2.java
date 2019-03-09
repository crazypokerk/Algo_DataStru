package HuaWei;

import java.util.*;

/**
 * @Date 2019/3/8 19:19
 */
public class Q_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<errorLog> l = new ArrayList<>();

        while (sc.hasNext()) {
            String input = sc.nextLine();
            String fileName = input.substring(input.lastIndexOf("\\") + 1);

            errorLog file = new errorLog(fileName, 1);
            l.add(file);
            for (int i = 0; i < l.size() - 1; i++) {
                if (l.get(i).fileName.equals(fileName)) {
                    l.get(i).count++;
                    l.remove(l.size() - 1);
                    break;
                }
            }
        }
        Collections.sort(l, (o1, o2) -> o2.count - o1.count);
        for (int i = 0; i < l.size(); i++) {
            if (i == 8) {
                break;
            }
            errorLog file = l.get(i);
            String str = file.fileName;
            int index = str.indexOf(" ");
            if (index > 16) {
                str = str.substring(index - 16);
            }
            System.out.println(str + " " + file.count);
        }
    }
}
class errorLog{
    public String fileName;
    public int count;

    public errorLog(String fileName, int count){
        this.count = count;
        this.fileName = fileName;
    }
}