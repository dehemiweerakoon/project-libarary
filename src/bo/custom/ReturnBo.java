package bo.custom;

import dto.BookDto;
import dto.MemberDto;
import dto.ReturnDto;

public interface ReturnBo {
    
    public Boolean saveReturn(ReturnDto returnDto,BookDto bookDto,MemberDto memberDto) throws Exception;
}
