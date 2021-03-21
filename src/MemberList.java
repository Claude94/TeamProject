
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
        String[][] notice = {
                {"번호", "제목", "내용"},     //[0][]
                {"1", "테스트!!", "테스트용 공지사항 입니다"}, //[1][]
                {"2", "테스팅", "테스트용 공지 입니다"} //[2][]

        };

        System.out.println("=== 동원 계시판 로그인! ===");
        System.out.print("=== 아이디: ");
        String id = sc.next();  //id 받기
        System.out.print("== 비밀번호: ");
        String password = sc.next(); //비밀번호 받기
        boolean idCheck = false; // 아이디 유무
        boolean pwCheck = false; // 비번 유무
        int memberNumber = 0; // 0은 null로 취급   멤버 아이디를 가져오기 위함
        int idIngredient = 4; // 멤버리스트의 성분을 추가하게될경우 이 부분및 배열만 수정하면된다
        int noticeIngredient = 3;
        for (int i = 1; i < memberList.length; i++) { //멤버 전체를 검토하여 id 확인
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
                    System.out.println("2.공지사항 작성");
                    System.out.println("=================");
                    System.out.print("메뉴 입력: ");
                    int page = sc.nextInt(); // 메뉴 입력받음
                    switch (page) { // 입력받은 메뉴를 스위치 케이스문으로 구별 밑 각 메뉴들의 기능
                        case 1:
                            //boolean re = true; //변수명 수정 필요
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
                                                switch (category_modify) {
                                                    case 1: // 아이디 변경
                                                        while (true) {
                                                            String changeId = sc.next();
                                                            String[][] vTemp = new String[memberList.length - 1][idIngredient];
                                                            for (int i = modifySearchId; i < memberList.length - 1; i++) {
                                                                memberList[i] = memberList[i + 1];
                                                            }
                                                            for (int i = 0; i < vTemp.length; i++) {
                                                                vTemp[i] = memberList[i];
                                                            }
                                                            int reduplication = 0;
                                                            for (reduplication = 1; reduplication < vTemp.length; reduplication++) { // 본인을 제외한 아이디가 중복되는지 확인
                                                                if (changeId.equals(vTemp[reduplication][1])) {
                                                                    break;
                                                                }
                                                            }
                                                            if (reduplication < vTemp.length) {
                                                                System.out.println("아이디가 중복됩니다");
                                                                System.out.print("다시 입력해 주세요 > ");
                                                            } else if (reduplication == vTemp.length) {
                                                                memberList[modifySearchId][category_modify] = changeId; //입력 받은 카테고리값 변경
                                                                System.out.print("변경완료!\n");
                                                                break;
                                                            }
                                                        }

                                                        break;

                                                    case 2:
                                                    case 3:
                                                        memberList[modifySearchId][category_modify] = sc.next(); //입력 받은 카테고리값 변경
                                                        System.out.print("변경완료!\n");
                                                        break;
                                                }

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
                                                System.out.printf("%s님의 아이디를 제거했습니다\n\n", memberList[delSearchId][1]);
                                                for (int i = delSearchId; i < memberList.length - 1; i++) {
                                                    memberList[i] = memberList[i + 1];
                                                }
                                                for (int i = 0; i < temp.length; i++) {
                                                    temp[i] = memberList[i];
                                                }
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
                                        String[][] temp2 = new String[memberList.length + 1][idIngredient]; // 배열 사이즈 증가를 위한 배열
                                        String[][] temp3 = new String[1][idIngredient]; // 생성을 위해 한줄 넣기위한 배열
                                        for (int i = 0; i < memberList.length; i++) {
                                            temp2[i] = memberList[i];
                                        }
                                        System.out.print("생성하실 회원번호를 입력해주세요! > ");
                                        while (true) {
                                            String createMemNum = sc.next(); // 생성할 회원번호
                                            int memberNumCheck;  //멤버리시트에서 중복되는지 확인을 위한 변수
                                            for (memberNumCheck = 0; memberNumCheck < memberList.length; memberNumCheck++) { // 중복확인
                                                if (createMemNum.equals(memberList[memberNumCheck][0])) {
                                                    break;
                                                }
                                            }
                                            if (memberNumCheck == memberList.length) { // 중복되지 않을경우 생성가능
                                                temp3[0][0] = createMemNum;
                                                break;
                                            } else {
                                                System.out.print("중복되는 회원번호 입니다 다시입력해주세요 > ");
                                            }
                                        }
                                        System.out.print("생성하실 ID를 입력해주세요! > ");
                                        while (true) {
                                            String createMemId = sc.next(); // ID를 생성하기위한 변수
                                            int memberIdCheck; // ID 중복체크를 위한 변수
                                            for (memberIdCheck = 0; memberIdCheck < memberList.length; memberIdCheck++) { //ID 중복체크
                                                if (createMemId.equals(memberList[memberIdCheck][1])) {
                                                    break;
                                                }
                                            }
                                            if (memberIdCheck == memberList.length) { // 아이디 넣기
                                                temp3[0][1] = createMemId;
                                                break;
                                            } else {
                                                System.out.print("중복되는 ID 입니다 다시입력해주세요 > ");
                                            }
                                        }
                                        System.out.print("생성하실 비밀번호를 입력해주세요! > ");
                                        temp3[0][2] = sc.next();
                                        System.out.print("생성하실 회원등급을 입력해주세요! > ");
                                        temp3[0][3] = sc.next();
                                        System.out.print("생성하신 정보입니다! \n");
                                        System.out.println("회원번호 아이디 비밀번호 회원등급");
                                        for (int l = 0; l < idIngredient; l++) {
                                            System.out.print(temp3[0][l] + "\t");
                                        }
                                        System.out.println("");
                                        temp2[temp2.length - 1] = temp3[0];
                                        memberList = temp2;
                                        temp2 = null;
                                        temp3 = null;

                                        break;
                                    case 4:
                                        // 사용자 ID 검색기능
                                        while (true) {
                                            System.out.print("찾을 멤버의 아이디를 입력하세요! > ");
                                            String modifyMId = sc.next(); // 원하는 ID 검사를 위해 입력 ID 를 담을 변수
                                            boolean searchContainId = false;
                                            int searchSearchId; // ID가 있는지 확인하기 위한 변수
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
                                                    System.out.print(memberList[searchSearchId][j] + "\t");
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
                                    case 8: // 이전으로 돌아가기 가능 계시판 관리 바로 윗줄의 while 문으로 돌아가짐
                                        System.out.println("");
                                        System.out.println("");
                                        System.out.println("");
                                        System.out.println("");
                                        //re = false; // 사용자 관리에서 머물게 해주는 반복문을 false 로 바꿈으로서 상위의 반복문이 다시 실행되게 만듬.
                                        break previous; //라벨을 활용해서 정지
                                    //break;
                                }
                            }
                            break;
                        case 2: //공지사항
                            previous2:
                            while (true) {
                                System.out.println("");
                                System.out.println("현재 등록된 공지사항");
                                for (int i = 1; i < notice.length; i++) {
                                    System.out.print(notice[i][0] + ") ");
                                    System.out.println(notice[i][1]);
                                    System.out.println(notice[i][2]);
                                    System.out.println("");
                                }


                                System.out.println("========================");
                                System.out.println("1.등록 2.수정 3.제거 8.이전");
                                System.out.println("================");
                                System.out.print("메뉴 입력: ");
                                int page3 = sc.nextInt();
                                switch (page3) {
                                    case 1:
                                        //공지 등록
                                        System.out.println("등록할 공지를 입력해 주세요");
                                        String[][] noticeTemp2 = new String[notice.length + 1][noticeIngredient];
                                        int i;
                                        for (i = 0; i < notice.length; i++) {
                                            noticeTemp2[i] = notice[i];
                                        }
                                        System.out.print("공지번호 > ");
                                        String noticeNum = sc.next();
                                        System.out.print("제목 > ");
                                        String title = sc.next();
                                        System.out.print("내용 > ");
                                        String content = sc.next();
                                        noticeTemp2[notice.length][0] = noticeNum;
                                        noticeTemp2[notice.length][1] = title;
                                        noticeTemp2[notice.length][2] = content;
                                        notice = noticeTemp2;
                                        noticeTemp2 = null;
                                        System.out.println("공지 등록 완료!");
                                        break;
                                    case 2:
                                        while (true) {
                                            System.out.print("수정할 공지의 번호를 입력하세요! > ");
                                            String modifyMId = sc.next();
                                            System.out.println("=================");
                                            boolean modifyContainNoticeNum = false;
                                            int modifySearchNoticeNum;
                                            for (modifySearchNoticeNum = 1; modifySearchNoticeNum < notice.length; modifySearchNoticeNum++) {
                                                if (modifyMId.equals(notice[modifySearchNoticeNum][0])) {
                                                    modifyContainNoticeNum = true;
                                                    break;
                                                }
                                            }
                                            if (modifyContainNoticeNum) { //선택한 공지번호가 있을경우
                                                System.out.println("1.공지번호 2.제목 3.내용");
                                                System.out.println("=================");
                                                System.out.print("수정할 카테고리번호를 입력하세요 > ");
                                                int category_modify = sc.nextInt();
                                                System.out.print("수정할 내용을 입력하세요 > ");
                                                switch (category_modify) {
                                                    case 1: // 공지번호 변경
                                                        while (true) {
                                                            String changeNoticeNum = sc.next();
                                                            String[][] nTemp = new String[notice.length - 1][noticeIngredient];
                                                            for (int o = modifySearchNoticeNum; o < notice.length - 1; o++) {
                                                                notice[o] = notice[o + 1];
                                                            }
                                                            for (int j = 0; j < nTemp.length; j++) {
                                                                nTemp[j] = notice[j];
                                                            }
                                                            int reduplication = 0;
                                                            for (reduplication = 1; reduplication < nTemp.length; reduplication++) { // 본인을 제외한 아이디가 중복되는지 확인
                                                                if (changeNoticeNum.equals(nTemp[reduplication][0])) {
                                                                    break;
                                                                }
                                                            }
                                                            if (reduplication < nTemp.length) {
                                                                System.out.println("공지번호가 중복됩니다");
                                                                System.out.print("다시 입력해 주세요 > ");
                                                            } else if (reduplication == nTemp.length) {
                                                                notice[modifySearchNoticeNum][category_modify - 1] = changeNoticeNum; //입력 받은 카테고리값 변경
                                                                System.out.print("변경완료!\n");
                                                                break;
                                                            }
                                                        }

                                                        break;

                                                    case 2:
                                                    case 3:
                                                        notice[modifySearchNoticeNum][category_modify - 1] = sc.next(); //입력 받은 카테고리값 변경
                                                        System.out.print("변경완료!\n");
                                                        break;
                                                }

                                                break;
                                            } else { // id가 없는경우
                                                System.out.println("등록되지 않은 공지 입니다");
                                            }
                                        }
                                        break; // 1번 브레이크
                                    case 3:
                                        //공지 삭제
                                        //삭제 알고리즘 가져와서 사용하면 될듯함
                                        while (true) {
                                            System.out.print("제거할 공지번호를 입력하세요! > ");
                                            String delNotice = sc.next();
                                            boolean delContainINotice = false;
                                            int delSearchNoticeNum;
                                            for (delSearchNoticeNum = 1; delSearchNoticeNum < notice.length; delSearchNoticeNum++) { // 선택한 ID가 있는지 확인
                                                if (delNotice.equals(notice[delSearchNoticeNum][0])) {
                                                    delContainINotice = true;
                                                    break;
                                                }
                                            }
                                            if (delContainINotice) { // 공지가 존재하면 실행
                                                String[][] temp = new String[notice.length - 1][noticeIngredient];
                                                System.out.printf("공지글[ %s ]를(을) 제거했습니다\n\n", notice[delSearchNoticeNum][2]);
                                                for (int j = delSearchNoticeNum; j < notice.length - 1; j++) {
                                                    notice[j] = notice[j + 1];
                                                }
                                                for (int k = 0; k < temp.length; k++) {
                                                    temp[k] = notice[k];
                                                }
                                                notice = temp;
                                                temp = null;
                                                break;
                                            } else { // 공지글이 존재하지 않음
                                                System.out.println("찾는 공지글이 없습니다");
                                            }
                                        }
                                        break;
                                    case 8:
                                        System.out.println("");
                                        System.out.println("");
                                        System.out.println("");
                                        System.out.println("");
                                        break previous2;
                                    //이전
                                }
                                //계시판에 따로 공지사항 가장 위에 올라오게 작성하면 될것 같음
                            }
                    }
                }
            }
            }else {
            System.out.println("=== 로그인 실패 ===");
            System.out.println("=== 아이디 / 비밀번호를 확인해주세요 ===");
        }
    }
}




