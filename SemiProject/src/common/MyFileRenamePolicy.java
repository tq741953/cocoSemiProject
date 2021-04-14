package common;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oreilly.servlet.multipart.FileRenamePolicy;

public class MyFileRenamePolicy implements FileRenamePolicy{

	@Override
	public File rename(File originFile) {
		// 전달 받은 원본 파일명을 중복 되는 값이 없게끔 변경해서 변경 된 파일명으로 반환
		// 변경명은 파일 업로드 한 시간(년얼일시분초) + 0~10만 사이의 랜덤 값(5자리의 랜덤값) 부여
		
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmss");
		int ranNum = (int)(Math.random() * 100000); // 0~99999 사이의 랜엄 값
		
		// 파일명을 변경하더라도 확장자를 유지하기 위해 별도로 확장자명 추출
		String name = originFile.getName();  // ex. flower.png
		int dot = name.lastIndexOf(".");     // 전달하는 문자가 가장 마지막 어디인덱스에 있는지 추출(확장자 앞의 . 인덱스 값 추출)
		String ext = "";
		if(dot != -1) {   // . 이 문자열 내에 있었을 경우 (해당값이 리턴이 안될경우 -1 리턴)
			ext = name.substring(dot);  // . 부터 끝까지 문자열 추출 ex. ".png"
		}
		
		// 최종적으로 수정할 파일 명
		String fileName = ft.format(new Date()) + ranNum + ext;
		
		// 변경 된 파일명으로 파일을 생성해서 리턴
		File newFile = new File(originFile.getParent(), fileName);
		
		return newFile;
	}

}
