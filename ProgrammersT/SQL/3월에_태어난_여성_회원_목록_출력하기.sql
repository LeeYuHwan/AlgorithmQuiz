SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH, '%Y-%m-%d') FROM MEMBER_PROFILE WHERE GENDER = 'W' AND DATE_FORMAT(DATE_OF_BIRTH,'%m') = '03' AND TLNO IS NOT NULL ORDER BY MEMBER_ID;