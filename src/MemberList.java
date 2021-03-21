
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
                //관리자 계정기능
                while (true) { // 내부에 while 문이 있어서 이전으로 돌아가는 값으로 사용가능
                    System.out.println("===== 게시판 관리 =====");
                    System.out.println("1.사용자 관리");
                    System.out.println("2.공지사항 작성");
                    System.out.println("=================");
                    System.out.print("메뉴 입력: ");
                    int page = sc.nextInt(); // 메뉴 입력받음
                    switch (page) { // 입력받은 메뉴를 스위치 케이스문으로 구별 밑 각 메뉴들의 기능
                        case 1:
                            //boolean re = true; //라벨을 사용하지 않기위해 만들었던 것
                            previous:
                            // 와일문 라벨 설정
                            while (true) { // 1번 사용자 관리 안에서 머물게 해줌
                                System.out.println("=== 사용자 관리 페이지 ===");
                                for (int i = 0; i < memberList.length; i++) {  // 전체 사용자 출력
                                    for (int j = 0; j < idIngredient; j++) {
                                        System.out.printf(memberList[i][j] + "\t");
                                    }
                                    System.out.println("");
                                }
                                System.out.println("=================");
                                System.out.println("1.수정 2.제거 3.생성 4.검색 8.이전"); //while 문으로 반복해줘야함
                                System.out.println("=================");
                                System.out.print("메뉴 입력: ");
                                int page1 = sc.nextInt(); // 수정 제거 생성 검색 이전을 선택하기 위한 숫자를 받음
                                switch (page1) {
                                    case 1: //수정기능
                                        while (true) {
                                            System.out.print("수정할 멤버의 아이디를 입력하세요! > ");
                                            String modifyMId = sc.next(); // 수정할 멤버 아이디 받기
                                            boolean modifyContainId = false; //아이디 값을 받아서 if 문을 컨트롤 하기위한 변수
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
                                                            String changeId = sc.next(); //변경할 아이디를 받음
                                                            String[][] vTemp = new String[memberList.length - 1][idIngredient]; // 선택된 아이디를 제외하고 중복체크를 위한 배열
                                                            for (int i = modifySearchId; i < memberList.length - 1; i++) {
                                                                memberList[i] = memberList[i + 1];
                                                            }
                                                            for (int i = 0; i < vTemp.length; i++) {
                                                                vTemp[i] = memberList[i];
                                                            }
                                                            int reduplication; // 중복이 있는지를 확인하기위한 변수
                                                            for (reduplication = 1; reduplication < vTemp.length; reduplication++) { // 본인을 제외한 아이디가 중복되는지 확인
                                                                if (changeId.equals(vTemp[reduplication][1])) {
                                                                    break;
                                                                }
                                                            }
                                                            if (reduplication < vTemp.length) { // 중간에 멈출경우 아이디가 중복되는 것
                                                                System.out.println("아이디가 중복됩니다");
                                                                System.out.print("다시 입력해 주세요 > ");
                                                            } else if (reduplication == vTemp.length) { // 끝까지가서 같아질 경우 아이디 중복이 없음
                                                                memberList[modifySearchId][category_modify] = changeId; //입력 받은 카테고리값 변경
                                                                System.out.print("변경완료!\n");
                                                                break;
                                                            }
                                                        }
                                                        break;

                                                    case 2: // 비밀번호 변경
                                                    case 3: // 회원등급 변경
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
                                            boolean delContainIdD = false; //if 문을 컨트롤 하기위한 변수
                                            int delSearchId; // 삭제 기능 에서 찾은 아이디 값을 저장할 변수
                                            for (delSearchId = 1; delSearchId < memberList.length; delSearchId++) { // 선택한 ID가 있는지 확인
                                                if (delId.equals(memberList[delSearchId][1])) {
                                                    delContainIdD = true;
                                                    break;
                                                }
                                            }
                                            if (delContainIdD) { // 아이디가 존재하면 실행됨
                                                String[][] temp = new String[memberList.length - 1][idIngredient]; //제거를 위한 가상배열 생성
                                                System.out.printf("%s님의 아이디를 제거했습니다\n\n", memberList[delSearchId][1]);
                                                for (int i = delSearchId; i < memberList.length - 1; i++) { //제거하기위한 반복문
                                                    memberList[i] = memberList[i + 1];
                                                }
                                                for (int i = 0; i < temp.length; i++) { //가상메모리에 회원정보를 저장
                                                    temp[i] = memberList[i];
                                                }
                                                memberList = temp; //
                                                temp = null;
                                                break;
                                            } else { // 찾는 아이디가 없을경우
                                                System.out.println("등록되지 않은 아이디 입니다");
                                            }
                                        }
                                        break;
                                    case 3: // 생성
                                        System.out.println("회원생성");
                                        String[][] temp2 = new String[memberList.length + 1][idIngredient]; // 배열 사이즈 증가를 위한 배열
                                        String[][] temp3 = new String[1][idIngredient]; // 수정된 배열을 받을 가상 변수
                                        for (int i = 0; i < memberList.length; i++) { //사이즈 증가를 위한 배열에 기존 멤버리스트 값을 저장
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
                                            if (memberNumCheck == memberList.length) { // 회원 번호가 중복되지 않을경우 생성가능
                                                temp3[0][0] = createMemNum; // 회원번호를 저장
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
                                        temp3[0][2] = sc.next(); // 비밀번호를 가상배열 위치에 저장
                                        System.out.print("생성하실 회원등급을 입력해주세요! > ");
                                        temp3[0][3] = sc.next(); // 회원등급을 가상배열 위치에 저장
                                        System.out.print("생성하신 정보입니다! \n");
                                        System.out.println("회원번호 아이디 비밀번호 회원등급");
                                        for (int l = 0; l < idIngredient; l++) {
                                            System.out.print(temp3[0][l] + "\t");
                                        }
                                        System.out.println("");
                                        temp2[temp2.length - 1] = temp3[0]; // temp2 가장 마지막에 temp3를 저장
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
                                            if (searchContainId) { // 찾을 아이디가 있는 경우
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
                            previous2: //라벨
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
                                int page3 = sc.nextInt(); // 등록 수정 제거 이전을 처리하기 위한 숫자를 받아옴
                                switch (page3) {
                                    case 1:
                                        //공지 등록
                                        System.out.println("등록할 공지를 입력해 주세요");
                                        String[][] noticeTemp2 = new String[notice.length + 1][noticeIngredient]; //새로운 공지를 등록하기 위한 배열
                                        int i;
                                        for (i = 0; i < notice.length; i++) { //반복문을 통해 가상배열에 공지값들을 저장
                                            noticeTemp2[i] = notice[i];
                                        }
                                        System.out.print("공지번호 > ");
                                        String noticeNum = sc.next();
                                        System.out.print("제목 > ");
                                        String title = sc.next();
                                        System.out.print("내용 > ");
                                        String content = sc.next();
                                        noticeTemp2[notice.length][0] = noticeNum; // 공지번호 저장   //중복되지 않게 추가 기능이 필요할 것으로 예상됨
                                        noticeTemp2[notice.length][1] = title; // 제목 저장
                                        noticeTemp2[notice.length][2] = content; // 내용 저장
                                        notice = noticeTemp2;
                                        noticeTemp2 = null;
                                        System.out.println("공지 등록 완료!");
                                        break;
                                    case 2:
                                        while (true) {
                                            System.out.print("수정할 공지의 번호를 입력하세요! > ");
                                            String modifyNoticeNum = sc.next(); // 공지 번호를 받음
                                            System.out.println("=================");
                                            boolean modifyContainNoticeNum = false; // if 문을 컨트롤 하기 위한 변수
                                            int modifySearchNoticeNum; //  중복되는 공지번호를 확인하기 위한 변수
                                            for (modifySearchNoticeNum = 1; modifySearchNoticeNum < notice.length; modifySearchNoticeNum++) {
                                                if (modifyNoticeNum.equals(notice[modifySearchNoticeNum][0])) {
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
                                                            String changeNoticeNum = sc.next(); // 변경을 위한 공지번호를 받음
                                                            String[][] nTemp = new String[notice.length - 1][noticeIngredient]; // 공지번호 중복을 확인하기 위한 배열
                                                            for (int o = modifySearchNoticeNum; o < notice.length - 1; o++) {
                                                                notice[o] = notice[o + 1];
                                                            }
                                                            for (int j = 0; j < nTemp.length; j++) { // 가상배열에 기본 공지값들을 저장
                                                                nTemp[j] = notice[j];
                                                            }
                                                            int reduplication = 0;
                                                            for (reduplication = 1; reduplication < nTemp.length; reduplication++) { // 본인을 제외한 공지번호가 중복되는지 확인
                                                                if (changeNoticeNum.equals(nTemp[reduplication][0])) {
                                                                    break;
                                                                }
                                                            }
                                                            if (reduplication < nTemp.length) { // 공지가 중복될 경우
                                                                System.out.println("공지번호가 중복됩니다");
                                                                System.out.print("다시 입력해 주세요 > ");
                                                            } else if (reduplication == nTemp.length) {
                                                                notice[modifySearchNoticeNum][category_modify - 1] = changeNoticeNum; //입력 받은 카테고리값 변경
                                                                System.out.print("변경완료!\n");
                                                                break;
                                                            }
                                                        }

                                                        break;

                                                    case 2: //제목
                                                    case 3: //내용
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
                                       // 제거할 공지가 없을경우 확인을 할 기능이 필요해보임
                                        while (true) {
                                            System.out.print("제거할 공지번호를 입력하세요! > ");
                                            String delNotice = sc.next();
                                            boolean delContainINotice = false;
                                            int delSearchNoticeNum; // 삭제할 공지번호의 위치를 저장할 변수
                                            for (delSearchNoticeNum = 1; delSearchNoticeNum < notice.length; delSearchNoticeNum++) { // 선택한 ID가 있는지 확인
                                                if (delNotice.equals(notice[delSearchNoticeNum][0])) {
                                                    delContainINotice = true;
                                                    break;
                                                }
                                            }
                                            if (delContainINotice) { // 공지가 존재하면 실행
                                                String[][] temp = new String[notice.length - 1][noticeIngredient]; // 공지를 제거하기 위한 배열
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




