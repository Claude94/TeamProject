package MiniProject;

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
        String id = sc.next();
        System.out.print("== 비밀번호: ");
        String password = sc.next();
        boolean idCheck = false;
        boolean pwCheck = false;
        int memberNumber = 0;
        for (int i = 1; i < memberList.length; i++) {
            for (int j = i; j < memberList.length; j++) {
                if (id.equals(memberList[i][1])) {
                    idCheck = true;
                    memberNumber = Integer.parseInt(memberList[i][0]);
                    break;
                }
            }
        }
        if (idCheck == true) {
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
                int page = sc.nextInt();
                switch (page) {
                    case 1:
                        System.out.println("=== 사용자 관리 페이지 ===");
                        System.out.println(Arrays.toString(memberList));
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



