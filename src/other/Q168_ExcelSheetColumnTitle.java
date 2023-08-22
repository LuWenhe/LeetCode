package other;

public class Q168_ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber > 0){
            //n --，是为了使得余数为0时代表A，为1代表B...
            columnNumber --;

            //获取余数，并转换为对应的符号
            char temp = (char)('A' + (columnNumber % 26));

            //添加到结果集
            sb.append(temp);
            columnNumber /= 26;
        }

        //输出结果
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = new Q168_ExcelSheetColumnTitle().convertToTitle(78);
        System.out.println(s);
    }

}
