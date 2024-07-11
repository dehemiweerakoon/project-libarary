package bo.custom;

import java.util.ArrayList;

import dto.MemberDto;

public interface MemberBo {
     public boolean saveMember(MemberDto MemberDTO) throws Exception;

    public boolean updateMember(MemberDto MemberDTO) throws Exception;

    public boolean deleteMember(Integer id) throws Exception;

    public MemberDto getMember(Integer id) throws Exception;

    public ArrayList<MemberDto> getAllMember() throws Exception;
}
