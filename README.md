# 2020-1학기 캡스톤 디자인 

1. 프로젝트 이름: MDA(Midddle Distance Application)

2. 프로젝트 소개: 보통의 사람들은 친구나 지인 등 타인과 만나기 위해 약속 장소를 정해야하는데 이 때 누군가에게는 상대적으로 멀어 불만이 생기고
                  이 점에 따라 난처해지는 경우가 있습니다.저희는 이러한 상황을 고려하여 각 사용자의 위치를 기반으로 하여 사용자들의 중간지점
                  을 구해 합리적으로 약속장소를 정할 수 있는 어플리케이션을 기획하게 되었습니다.

3. 참여 인원: 4명: 안드로이드(2), 백엔드(2)

4. 사용기술 및 스택: 백엔드: Java(SpringBoot),RDS(Mysql), Ec2, Odsay API(대중교통)
                    프론트: Kotlin, GoogleMap API 
                  
5. 플로우: 어플리케이션에 접속 - Splash화면 확인 - New Schedule 버튼 선택 -카테고리 선택(Cafe, Restaurant, Activity)
               - Schedule이름 설정 및 인원 입력 - 나이 및 성별 선택 - 선택한 카테고리의 분위기 설정(Date, Brunch, Studyng등)
               - Complete버튼 선택 - Schedule을 생성한 Owner의 위치가 뜬 지도 표기 - 상단에 공유 버튼을 통해 다른 client 초대
               - 각 client 입장 후 사용자의 위치를 기반으로 중간점 산출 및 노출 - 노출된 중간점에 기반하여 초기 설정값에 따라 추천 장소 노출
               - 사용자들의 선택을 통해 장소 투표 - Owner의 최종 결정으로 Schedule 장소 결정 - 시간, 날짜 지정 - Complete 버튼 선택
               - Schedule 캘린더에 저장 - 어플 하단에 네비게이션바를 통해 지난 Schedule 및 예정된 Schedule 가능  
                
6. 기능: 프론트에서 입력받은 상태값을 백엔드로 보내 저장,
         상태값을 받은 다음 지도 상의 사용자 위치의 위도, 경도 값을 받아 사용자들의 중간지점 계산, 이 때 중간지점은 각 사용자들의 좌표를 통한            도형의 무게중심을 활용하였습니다.
     