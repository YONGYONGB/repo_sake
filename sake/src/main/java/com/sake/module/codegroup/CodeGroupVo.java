package com.sake.module.codegroup;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.sake.module.share.Menu;

public class CodeGroupVo extends Menu{

	private String cg_id;
	

	public String getCg_id() {
		return cg_id;
	}

	public void setCg_id(String cg_id) {
		this.cg_id = cg_id;
	}
	
	private String shDateStart;
    private String shDateEnd;

    public void add30MinutesToEndIfSame() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"); // 날짜 형식 맞춰주기
        LocalDateTime start = LocalDateTime.parse(shDateStart, formatter);
        LocalDateTime end = LocalDateTime.parse(shDateEnd, formatter);

        // shDateStart와 shDateEnd가 같으면 shDateEnd에 30분 더하기
        if (start.isEqual(end)) {
        	end = end.plusHours(11);
            end = end.plusMinutes(30);
            shDateEnd = end.format(formatter); // 새로운 shDateEnd 값으로 업데이트
        }
    }

    public void setShDateStart(String shDateStart) {
        this.shDateStart = shDateStart;
    }

    public void setShDateEnd(String shDateEnd) {
        this.shDateEnd = shDateEnd;
    }

    public String getShDateStart() {
        return shDateStart;
    }

    public String getShDateEnd() {
        return shDateEnd;
    }
}
