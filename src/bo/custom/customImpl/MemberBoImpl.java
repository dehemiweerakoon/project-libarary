package bo.custom.customImpl;

import java.util.ArrayList;

import bo.custom.MemberBo;
import dao.DaoFactory;
import dao.custom.Memberdao;
import dto.MemberDto;
import entity.Member;

public class MemberBoImpl implements MemberBo{

    private Memberdao memberdao = DaoFactory.getDaoFactory().getDao(DaoFactory.DaoType.MEMBER);

    @Override
    public boolean saveMember(MemberDto MemberDTO) throws Exception {
        return memberdao.save(new Member(MemberDTO.getId(), MemberDTO.getName(), MemberDTO.getContactNo(), MemberDTO.getAddress(), MemberDTO.getFee()));
    }

    @Override
    public boolean updateMember(MemberDto MemberDTO) throws Exception {
        return memberdao.update(new Member(MemberDTO.getId(), MemberDTO.getName(), MemberDTO.getContactNo(), MemberDTO.getAddress(), MemberDTO.getFee()));
    }

    @Override
    public boolean deleteMember(Integer id) throws Exception {
        return memberdao.delete(id);
    }

    @Override
    public MemberDto getMember(Integer id) throws Exception {
      Member member = memberdao.get(id);
      if(member != null){
        return new MemberDto(
            member.getId(),member.getName(),member.getContactNo(),member.getAddress(),member.getFee()
        );
      }
      return null;
    }

    @Override
    public ArrayList<MemberDto> getAllMember() throws Exception {
        ArrayList<Member> members = memberdao.getAll();
        ArrayList<MemberDto> memberDtos = new ArrayList<>();
        for(Member mem: members){
            MemberDto memberDto = new MemberDto(mem.getId(), mem.getName(), mem.getContactNo(), mem.getAddress(), mem.getFee());
            memberDtos.add(memberDto);
        }
        return memberDtos;
    }
    
}
