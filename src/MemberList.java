
import java.util.*;

public class MemberList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[][] memberList = {
                {"회원 번호", "아이디", "비밀번호", "회원등급"},    //[0][] 검색기본 베이스 구분
                {"1", "admin", "admin", "1"}, //[1][]
                {"2", "철수", "123", "2"}, //[2][]
                {"3", "민수", "민수", "2"}, //[3][]
                {"4", "영희", "영희", "2"}, //[4][]
                {"5", "둘리", "둘리", "2"}, //[5][]
        };
        System.out.println("=== 동원 계시판 로그인! ===");
        System.out.print("=== 아이디: ");
        String id = sc.next();  //id 받기
        System.out.print("== 비밀번호: ");
        String password = sc.next(); //비밀번호 받기
        boolean idCheck = false; // 아이디 유무
        boolean pwCheck = false; // 비번 유무
        int memberNumber = 0; // 0은 null로 취급   멤버 아이디를 가져오기 위함

        for (int i = 1; i < memberList.length; i++) { //멤버 전체를 검토하여 id확인
            if (id.equals(memberList[i][1])) {
                idCheck = true;
                memberNumber = Integer.parseInt(memberList[i][0]);
                break;
            }
        }

        if (idCheck == true) { // 아이디가 존재하면 비밀번호 체크 회원번호를 이용해서 체크한다.
            if (password.equals(memberList[memberNumber][2])) {
                pwCheck = true;
            }
        }
        if (idCheck == true && pwCheck == true) {
            System.out.println("=== 로그인 성공! ===");
            System.out.printf("=== %s님 어서오세요! ===\n", memberList[memberNumber][1]);
            //사용자 계정 넣기
            if (idCheck == true && pwCheck == true && memberNumber == 1) {
                System.out.println("=== 이 계정은 관리자 입니다 ===");
                //관리자 계정기능 넣기
                System.out.println("===== 계시판 관리 =====");
                System.out.println("1.사용자 관리");
                System.out.print("메뉴 입력: ");
                int page = sc.nextInt(); // 메뉴 입력받음
                switch (page) { // 입력받은 메뉴를 스위치 케이스문으로 구별 밑 각 메뉴들의 기능
                    case 1:
                        System.out.println("=== 사용자 관리 페이지 ===");
                        for (int i = 0; i < memberList.length; i++) {  // 전체 사용자 출력 admin 포함
                            for (int j = 0; j < 4; j++) {
                                System.out.printf(memberList[i][j] + "\t");
                            }
                            System.out.println("");
                        }
                        System.out.println("=================");
                        System.out.println("1.수정 2.제거 3.생성 4.이전"); //while 문으로 반복해줘야함
                        System.out.print("메뉴 입력: ");
                        int page1 = sc.nextInt();
                        switch (page1) {
                            case 1: //수정기능
                                System.out.print("수정할 멤버의 회원번호를 입력하세요! > ");
                                String modifyMId = sc.next();
                                System.out.println("1.아이디 2.비밀번호 3.회원등급");
                                System.out.println("=================");
                                System.out.print("수정할 카테고리번호를 입력하세요 > ");
                                int category = sc.nextInt();
                                System.out.print("수정할 내용을 입력하세요 > ");
                                memberList[Integer.parseInt(modifyMId)][category] = sc.next(); //입력 받은 카테고리값 변경

                                for (int i = 0; i < 4; i++) {
                                    System.out.printf(memberList[Integer.parseInt(modifyMId)][i] + "\t");
                                }//나중 반복문을 통한 멤버리스트 전부를 보여주는것으로 만들기
                                System.out.print("변경완료!\n");
                                break; // 1번 브레이크
                            case 2: //제거
                                break;
                            case 3: // 생성
                                break;
                            case 4: // 이전
                                break;
                        }

                        break;

                }
            }
        } else {
            System.out.println("=== 로그인 실패 ===");
            System.out.println("=== 아이디 / 비밀번호를 확인해주세요 ===");
        }
        /*System.out.println("idCheck: " + idCheck);
        System.out.println("pwCheck: " + pwCheck);
        System.out.println("memberNumber: " + memberNumber);*/
    }
}
//멤버리스트를 반복해서 id를 체크해야함
//if를 사용해서 있는지 확인 있는것들 true변환



