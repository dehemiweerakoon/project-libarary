package dao.custom.customImpl;

import java.sql.ResultSet;
import java.util.ArrayList;

import dao.CrudUtill;
import dao.custom.Memberdao;
import entity.Member;

public class MemberDaoImpl implements Memberdao{

    @Override
    public boolean save(Member t) throws Exception {
        return CrudUtill.execute("INSERT INTO Member(name,contactNo,address,fee) VALUES(?,?,?,?)", t.getName(),t.getContactNo(),t.getAddress(),t.getFee());
    }

    @Override
    public boolean delete(Integer id) throws Exception {
        return CrudUtill.execute("DELETE FROM `Member` WHERE id=?",id);
    }

    @Override
    public boolean update(Member t) throws Exception {
        return CrudUtill.execute("UPDATE `Member` SET name=? ,contactNo=? ,address=? ,fee=? WHERE id=?", t.getName(),t.getContactNo(),t.getAddress(),t.getFee(),t.getId());
    }

    @Override
    public Member get(Integer id) throws Exception {
       ResultSet resultSet = CrudUtill.execute("SELECT * FROM `Member` WHERE id=?", id);
       while (resultSet.next()) {
         return new Member(
            resultSet.getInt(1), 
            resultSet.getString(1),
            resultSet.getString(3),
            resultSet.getString(4), 
            resultSet.getInt(5));
       }
       return null;
    }

    @Override
    public ArrayList<Member> getAll() throws Exception {
        ResultSet resultSet = CrudUtill.execute("SELECT * FROM `Member`");
        ArrayList<Member> Members = new ArrayList<>();
        while (resultSet.next()) {
            Member member = new Member(resultSet.getInt(1), 
            resultSet.getString(2),
            resultSet.getString(3),
            resultSet.getString(4), 
            resultSet.getInt(5));
            Members.add(member);
        }
        return Members;
    }
    
}
