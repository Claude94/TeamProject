import java.util.Arrays;
import java.util.Scanner;

public class TeamProject {
    public static void main(String[] args) {
        //호면에 표시되는 기능
        while (true) {
            System.out.println("계시판");
            System.out.println("======================");
            System.out.println("5.계시글 작성");
            System.out.println("6.계시글 검색");
            System.out.println("7.프로그램 종료");
            System.out.println("======================");
            System.out.print(">> ");
            //임시 배열
//        String[] newDoc = {"1", "안녕", "안녕하세요"};
            String[][] newDoc = new String[1000][3];
            int articleCount = 0; // 실제 저장된 게시물 수
            //입력 받는 기능
            Scanner sc = new Scanner(System.in);
            int indexNum = sc.nextInt();
            //입력 된 숫자에 따라 기능을 구별 하는 기능
            if (indexNum == 5) {

                String content = "";
                String[] article = new String[3];
                for (int i = 0; i < 3; i++) {
                    if (i == 0) {
                        content = "번호";
                    } else if (i == 1) {
                        content = "제목";
                    } else {
                        content = "내용";
                    }
                    System.out.printf("- 새 글에 %s을 작성해 주세요 : ", content);
                    String newDocContent = sc.next();
                    article[i] = newDocContent;
                }
                // 작성 된 계시글 확인
                System.out.println("\n==== 작성된 계시글 ====");
                System.out.printf("번호 : %s \n제목 : %s \n내용 : %s\n", article[0], article[1], article[2]);
                newDoc[articleCount] = article;
                articleCount++;
                System.out.println(newDoc.length);
            } else if (indexNum == 6) {
                // 작성글 검색 기능
                System.out.println(Arrays.toString(newDoc));
                System.out.println("검색 할 글의 번호를 입력하세요");
                System.out.print(">> ");
                String indexSearchNum = sc.next();
                // 번호 매칭 기능
                boolean searchNum = false;
                int i = 0;
                for (i = 0; i < newDoc.length; i++) {
                    for (int j = 0; j < newDoc.length; j++) {
                        if (indexSearchNum.equals(newDoc[i][j])) {
                            searchNum = true;
                            break;

                        }
                    }
                }
                //검색 된 계시글 화면 표현
                if (searchNum) {
                    System.out.println("==== 검색 된 계시글 ====");
                    System.out.printf("번호 : %s \n제목 : %s \n내용 : %s", newDoc[0], newDoc[1], newDoc[2]);
                } else {
                    System.out.println("등록 된 번호가 없습니다");
                    System.out.print(">> ");
                }
            } else if (indexNum == 7) {
                //프로그램 종료 기능
                System.out.println("프로그램을 종료 합니다");
            }
        }
    }
}