
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
        int idIngredient = 4;
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
                boolean after = true; //이전으로 가기위한 논리값
                while (after) { // 내부에 while 문이 있어서 이전으로 돌아가는 값으로 사용가능
                    System.out.println("===== 계시판 관리 =====");
                    System.out.println("1.사용자 관리");
                    System.out.println("=================");
                    System.out.print("메뉴 입력: ");
                    int page = sc.nextInt(); // 메뉴 입력받음
                    switch (page) { // 입력받은 메뉴를 스위치 케이스문으로 구별 밑 각 메뉴들의 기능
                        case 1:
//                            boolean re = true; //변수명 수정 필요
                            previous:
                            // 와일문 라벨 설정
                            while (true) { // 1번 사용자 관리 안에서 머물게 해줌
                                System.out.println("=== 사용자 관리 페이지 ===");
                                for (int i = 0; i < memberList.length; i++) {  // 전체 사용자 출력 admin 포함
                                    for (int j = 0; j < idIngredient; j++) {
                                        System.out.printf(memberList[i][j] + "\t");
                                    }
                                    System.out.println("");
                                }
                                System.out.println("=================");
                                System.out.println("1.수정 2.제거 3.생성 4.검색 8.이전"); //while 문으로 반복해줘야함
                                System.out.println("=================");
                                System.out.print("메뉴 입력: ");
                                int page1 = sc.nextInt();
                                switch (page1) {
                                    case 1: //수정기능
                                        while (true) {
                                            System.out.print("수정할 멤버의 아이디를 입력하세요! > ");
                                            String modifyMId = sc.next();
                                            boolean modifyContainId = false;
                                            int modifySearchId; // 수정 기능에서 찾은 아이디 값을 저장할 변수
                                            for (modifySearchId = 1; modifySearchId < memberList.length; modifySearchId++) { // 선택한 ID가 있는지 확인
                                                if (modifyMId.equals(memberList[modifySearchId][1])) {
                                                    modifyContainId = true;
                                                    break;
                                                }
                                            }
                                            if (modifyContainId) { //선택한 id가 있을경우
                                                System.out.println("1.아이디 2.비밀번호 3.회원등급");
                                                System.out.println("=================");
                                                System.out.print("수정할 카테고리번호를 입력하세요 > ");
                                                int category_modify = sc.nextInt();
                                                System.out.print("수정할 내용을 입력하세요 > ");
                                                memberList[modifySearchId][category_modify] = sc.next(); //입력 받은 카테고리값 변경
                                                System.out.print("변경완료!\n");
                                                break;
                                            } else { // id가 없는경우
                                                System.out.println("등록되지 않은 아이디 입니다");
                                            }
                                        }
                                        break; // 1번 브레이크
                                    case 2: //제거
                                        while (true) {
                                            System.out.print("제거할 멤버의 아이디를 입력하세요! > ");
                                            String delId = sc.next(); // 지울 아이디를 저장할 변수
                                            boolean delContainIdD = false;
                                            int delSearchId; // 삭제 기능 에서 찾은 아이디 값을 저장할 변수
                                            for (delSearchId = 1; delSearchId < memberList.length; delSearchId++) { // 선택한 ID가 있는지 확인
                                                if (delId.equals(memberList[delSearchId][1])) {
                                                    delContainIdD = true;
                                                    break;
                                                }
                                            }
                                            if (delContainIdD) { // 아이디가 존재하면 실행됨
                                                String[][] temp = new String[memberList.length - 1][idIngredient];
                                                for (int i = delSearchId; i < memberList.length - 1; i++) {
                                                    memberList[i] = memberList[i + 1];
                                                }
                                                for (int i = 0; i < temp.length; i++) {
                                                    temp[i] = memberList[i];
                                                }
                                                System.out.printf("%s님의 아이디를 제거했습니다\n\n", memberList[delSearchId][1]);
                                                memberList = temp;
                                                temp = null;
                                                break;
                                            } else { // 찾는 아이디가 없을경우
                                                System.out.println("등록되지 않은 아이디 입니다");
                                            }
                                        }
                                        break;
                                    case 3: // 생성
                                        // 회원 번호에 빈자리가 있으면 채워넣기 OR 그냥 제일 뒤에 순번대로 넣기
                                        // 일단 가장 뒤에 넣는 방식으로 생성
                                        System.out.println("회원생성");

                                        break;
                                    case 4:
                                        // 사용자 ID 검색기능
                                        while (true) {
                                            System.out.print("찾을 멤버의 아이디를 입력하세요! > ");
                                            String modifyMId = sc.next();
                                            boolean searchContainId = false;
                                            int searchSearchId; // 수정 기능에서 찾은 아이디 값을 저장할 변수
                                            for (searchSearchId = 1; searchSearchId < memberList.length; searchSearchId++) { // 선택한 ID가 있는지 확인
                                                if (modifyMId.equals(memberList[searchSearchId][1])) {
                                                    searchContainId = true;
                                                    break;
                                                }
                                            }
                                            if (searchContainId) {
                                                System.out.println("찾은 아이디의 정보입니다.");
                                                System.out.println("================");
                                                System.out.println("회원번호 아이디 비밀번호 회원등급");
                                                for (int j = 0; j < idIngredient; j++) {
                                                    System.out.printf(memberList[searchSearchId][j] + "\t");
                                                }
                                                System.out.println("");
                                                System.out.println("================");
                                                System.out.println("");
                                                break;
                                            } else {
                                                System.out.println("없는 아이디 입니다");
                                            }
                                        }
                                        break;
                                    case 8: // 이전으로 돌아가기 가능 계시판 관리 바로 윗줄의 while문으로 돌아가짐
                                        System.out.println("");
                                        System.out.println("");
                                        System.out.println("");
                                        System.out.println("");
                                        //re = false; // 사용자 관리에서 머물게 해주는 반복문을 false로 바꿈으로서 상위의 반복문이 다시 실행되게 만듬.
                                        // 이전
                                        // 1번 while 안의 2번 while로 구성해서  true든 false 든 종료시키게 만들어서
                                        // 2번 와일문을 종료하면 1번와일문으로 돌아가기 때문에 이전으로 가는 상황이 연출될 것 같다 .
                                        break previous; //라벨을 활용해서 정지
                                    //break;
                                }
                            }

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
}
//멤버리스트를 반복해서 id를 체크해야함
//if를 사용해서 있는지 확인 있는것들 true변환



