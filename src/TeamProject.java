import java.util.Arrays;
import java.util.Scanner;

public class TeamProject {
    public static void main(String[] args) {
        int articleCount = 0; // 실제 저장된 게시물 수
        String[][] newDoc = new String[1000][4];
        //화면에 표시되는 기능
        while (true) {
            System.out.println("=======================");
            System.out.println("++++++++ 계시판 ++++++++");
            System.out.println("=======================");
            System.out.println("1.게시판 글 작성");
            System.out.println("2.게시판 글 전체 보기");
            System.out.println("3.게시판 글 수정");
            System.out.println("4.게시판 글 삭제");
            System.out.println("5.게시판 글 검색");
            System.out.println("6.게시판 프로그램 종료");
            System.out.println("=======================");
            System.out.print(">> ");
            //임시 배열
//        String[] newDoc = {"1", "안녕", "안녕하세요"};
            //입력 받는 기능
            Scanner sc = new Scanner(System.in);
            String[] article = new String[4];
            int indexNum = sc.nextInt();
            //입력 된 숫자에 따라 기능을 구별 하는 기능
            if (indexNum == 1) {
                String content = "";
                for (int i = 0; i < 4; i++) {
                    if (i == 0) {
                        content = "번호";
                    } else if (i == 1) {
                        content = "작성자";
                    } else if (i == 2) {
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
                System.out.printf("번호 : %s \n작성자 : %s \n제목 : %s \n내용 : %s\n", article[0], article[1], article[2], article[3]);
                newDoc[articleCount] = article;
                articleCount++;
//                System.out.println("articleCount = " + articleCount);
//                System.out.println(Arrays.deepToString(newDoc));
            } else if (indexNum == 2) {
                // 2. 게시판 글 전체 보기
                System.out.println("전체 게시판 글 보기입니다.");
//                    System.out.println(boardCount);
                if (articleCount == 0) {
                    System.out.println("등록된 게시물이 없습니다.");
                } else {
                    for (int i = 0; i < articleCount; i++) {
                        System.out.printf("글 번호 : %s | 작성자 : %s | 제목 : %s | 내용 : %s \n"
                                , newDoc[i][0], newDoc[i][1], newDoc[i][2], newDoc[i][3]);
//                        System.out.println(Arrays.deepToString(newDoc));
                    }
                } //문제없음
            } else if (indexNum == 3) {
                // 3. 게시판 글 수정
                if (articleCount == 0) {
                    System.out.println("등록된 게시물이 없습니다.");
                } else {
                    System.out.println("수정할 글 번호를 입력해주세요.");
                    String modifyIdx = sc.next();
                    System.out.print(">> ");

                    // 게시글 조회 여부
                    boolean check = false;

                    for (int i = 0; i < articleCount; i++) {
                        if (modifyIdx.equals(newDoc[i][0])) {
                            System.out.printf("글 번호 : %s | 작성자 : %s | 제목 : %s | 내용 : %s \n"
                                    , newDoc[i][0], newDoc[i][1], newDoc[i][2], newDoc[i][3]);
                            while (true) {
                                System.out.println("해당 게시물을 정말로 수정하시겠습니까? y/n ");
                                System.out.print(">> ");
                                String modifyMenu = sc.next();

                                if (modifyMenu.equals("y")) {
                                    article = new String[4];// 주의 요망
                                    article[0] = newDoc[i][0];
                                    System.out.println("===== " + article[0] + "번 게시물 =====");
                                    System.out.println("수정 작성자 >> ");
                                    article[1] = sc.next();
                                    System.out.println("수정 제목 >> ");
                                    article[2] = sc.next();
                                    System.out.println("수정 내용 >> ");
                                    article[3] = sc.next();

                                    newDoc[i] = article;

                                    check = true;
                                    break;
                                } else if (modifyMenu.equals("n")) {
                                    System.out.println("수정이 취소되었습니다.");
                                    break;
                                } else {
                                    System.out.println("다시 입력하세요.");
                                }
                            }

                        }
                    }
                    if (!check) {
                        System.out.println("게시글 번호를 다시 확인해주세요.");
                    }

                }
            } else if (indexNum == 4) {
                // 4. 게시판 글 삭제
                if (articleCount == 0) {
                    System.out.println("등록된 게시물이 없습니다.");
                } else {
//                        System.out.println(Arrays.deepToString(boardArr));
                    System.out.println("삭제할 글 번호를 입력해주세요.");
                    String deleteIdx = sc.next();
                    System.out.print(">> ");

                    for (int i = 0; i < articleCount; i++) {
                        if (newDoc[i][0].equals(deleteIdx)) {
                            // 삭제할 글 번호가 입력한 번호와 일치할 때
                            System.out.printf("글 번호 : %s | 작성자 : %s | 제목 : %s | 내용 : %s \n"
                                    , newDoc[i][0], newDoc[i][1], newDoc[i][2], newDoc[i][3]);
                            while (true) {
                                System.out.println("해당 게시물을 정말로 삭제하시겠습니까? y/n ");
                                System.out.print(">> ");
                                String deleteMenu = sc.next();
                                if (deleteMenu.equals("y")) {
                                    // 삭제 게시물 배열에서 삭제
                                    for (int b = 0; b < newDoc.length - 1; b++) {
                                        newDoc[b] = newDoc[b + 1];
                                    }
                                    String[][] temp = new String[newDoc.length - 1][];
                                    for (int j = 0; j < temp.length; j++) {
                                        temp[i] = newDoc[i];
                                    }
                                    newDoc[i] = temp[i];
                                    temp[i] = null;
//                                    System.out.println(Arrays.deepToString(boardArr));

                                    // 총 게시물 수 감소
                                    articleCount--;

//                                    System.out.println(boardCount);
                                    System.out.println("삭제 완료되었습니다.");
                                    for (int k = 0; k < articleCount; k++) {
                                        System.out.printf("글 번호 : %s | 작성자 : %s | 제목 : %s | 내용 : %s \n"
                                                , newDoc[k][0], newDoc[k][1], newDoc[k][2], newDoc[k][3]);
                                    }
                                    break;

                                } else if (deleteMenu.equals("n")) {
                                    System.out.println("삭제가 취소되었습니다.");
                                    break;
                                } else {
                                    System.out.println("다시 입력하세요.");
                                }
                            }
                        }

                    }

                }
            } else if (indexNum == 5) {
                // 작성글 검색 기능
//                System.out.println(Arrays.deepToString(newDoc));
                System.out.println("검색 할 글의 번호를 입력하세요");
                System.out.print(">> ");
                String indexSearchNum = sc.next();
                // 번호 매칭 기능
                boolean searchNum = false;
                int i = 0;
                for (i = 0; i < newDoc.length; i++) {
                    if (indexSearchNum.equals(newDoc[i][0])) {
                        searchNum = true;
                        break;
                    }
                }
                //검색 된 계시글 화면 표현
                if (searchNum) {
                    System.out.println("==== 검색 된 계시글 ====");
                    System.out.printf("번호 : %s \n작성자 : %s \n제목 : %s \n내용 : %s\n", newDoc[i][0], newDoc[i][1], newDoc[i][2], newDoc[i][3]);
                } else {
                    System.out.println("등록 된 번호가 없습니다");
                    System.out.print(">> ");
                }
            } else if (indexNum == 6) {
                //프로그램 종료 기능
                System.out.println("프로그램을 종료 합니다");
                break;

            }
        }
    }
}