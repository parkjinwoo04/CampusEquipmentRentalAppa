package com.example.campusequipmentrentalapp.data

import com.example.campusequipmentrentalapp.model.Equipment
import com.example.campusequipmentrentalapp.model.RentalStatus

//데이터베이스 대신 사용할 샘플 데이터 레퍼지터리(보관)
object EquipmentRepository {

    val equipmentList :List<Equipment> = listOf(
        Equipment(
            id = 1,
            name = "노트북",
            category = "컴퓨터",
            icon = "💻",
            status = RentalStatus.AVAILABLE,
            maxRentalDays = 3,
            location = "미디어관 604호",
            description = "수업 발표와 팀 프로젝트에 사용할 수 있는 Windows 노트북입니다."
        ),
        Equipment(
            id = 2,
            name = "태블릿",
            category = "모바일",
            icon = "📱",
            status = RentalStatus.AVAILABLE,
            maxRentalDays = 2,
            location = "미디어관 604호",
            description = "필기, 전자책, 모바일 앱 테스트에 사용할 수 있는 Android 태블릿입니다."
        ),
        Equipment(
            id = 3,
            name = "웹캠",
            category = "영상",
            icon = "📷",
            status = RentalStatus.RENTED,
            maxRentalDays = 3,
            location = "학과 사무실",
            description = "온라인 발표와 영상 촬영에 사용할 수 있는 Full HD 웹캠입니다."
        ),
        Equipment(
            id = 4,
            name = "삼각대",
            category = "촬영",
            icon = "🎬",
            status = RentalStatus.AVAILABLE,
            maxRentalDays = 5,
            location = "미디어관 605호",
            description = "스마트폰과 소형 카메라 촬영에 사용할 수 있는 높이 조절 삼각대입니다."
        ),
        Equipment(
            id = 5,
            name = "빔프로젝터",
            category = "발표",
            icon = "📽️",
            status = RentalStatus.MAINTENANCE,
            maxRentalDays = 1,
            location = "학과 사무실",
            description = "팀 발표와 행사에 사용할 수 있는 휴대용 프로젝터입니다. 현재 점검 중입니다."
        ),
        Equipment(
            id = 6,
            name = "VR 기기",
            category = "실감미디어",
            icon = "🥽",
            status = RentalStatus.AVAILABLE,
            maxRentalDays = 1,
            location = "AI 실습실",
            description = "VR 콘텐츠 체험과 캡스톤 프로젝트 테스트에 사용하는 독립형 VR 기기입니다."
        ),
        Equipment(
            id = 7,
            name = "무선 마이크",
            category = "음향",
            icon = "🎤",
            status = RentalStatus.AVAILABLE,
            maxRentalDays = 2,
            location = "학과 사무실",
            description = "발표, 촬영, 행사 진행에 사용할 수 있는 충전식 무선 마이크입니다."
        ),
        Equipment(
            id = 8,
            name = "휴대용 스피커",
            category = "음향",
            icon = "🔊",
            status = RentalStatus.RENTED,
            maxRentalDays = 2,
            location = "학과 사무실",
            description = "소규모 행사와 프로젝트 시연에 사용할 수 있는 Bluetooth 스피커입니다."
        ),
        Equipment(
            id = 9,
            name = "데스크톱 PC",
            category = "컴퓨터",
            icon = "🖥️",
            status = RentalStatus.AVAILABLE,
            maxRentalDays = 4,
            location = "컴퓨터실 101호",
            description = "고성능 그래픽 처리가 필요한 영상편집, 3D 모델링에 사용할 수 있습니다."
        ),
        Equipment(
            id = 10,
            name = "DSLR 카메라",
            category = "영상",
            icon = "📸",
            status = RentalStatus.AVAILABLE,
            maxRentalDays = 6,
            location = "미디어관 605호",
            description = "고화질 사진 촬영과 영상 제작에 사용할 수 있는 전문 DSLR 카메라입니다."
        ),
        Equipment(
            id = 11,
            name = "액션캠",
            category = "영상",
            icon = "🎥",
            status = RentalStatus.AVAILABLE,
            maxRentalDays = 5,
            location = "미디어관 604호",
            description = "방수, 방진 기능이 있는 소형 액션캠으로 극한 환경 촬영에 적합합니다."
        ),
        Equipment(
            id = 12,
            name = "조명 세트",
            category = "촬영",
            icon = "💡",
            status = RentalStatus.MAINTENANCE,
            maxRentalDays = 3,
            location = "미디어관 605호",
            description = "스튜디오 촬영 및 영상 촬영에 필요한 3개 조명 세트입니다. 현재 점검 중."
        ),
        Equipment(
            id = 13,
            name = "포인터",
            category = "발표",
            icon = "🔴",
            status = RentalStatus.AVAILABLE,
            maxRentalDays = 7,
            location = "학과 사무실",
            description = "프레젠테이션 발표 시 사용하는 레이저 포인터 및 프레젠터입니다."
        ),
        Equipment(
            id = 14,
            name = "노이즈캔슬링 헤드폰",
            category = "음향",
            icon = "🎧",
            status = RentalStatus.AVAILABLE,
            maxRentalDays = 4,
            location = "미디어관 604호",
            description = "음성녹음, 음악 제작, 영상편집 등에 사용할 수 있는 고급 헤드폰입니다."
        ),
        Equipment(
            id = 15,
            name = "스마트폰",
            category = "모바일",
            icon = "📞",
            status = RentalStatus.RENTED,
            maxRentalDays = 2,
            location = "미디어관 604호",
            description = "모바일 앱 개발 테스트 및 동영상 촬영에 사용할 수 있는 안드로이드 스마트폰입니다."
        )
    )
    fun findById(id:Int) : Equipment ?= equipmentList.find{ equipment -> equipment.id == id}


}






