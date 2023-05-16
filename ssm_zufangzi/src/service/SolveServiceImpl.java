// 
// 
// 

package service;

import Pojo.Wrong;
import Pojo.Solve;
import java.util.List;
import Pojo.QueryVo;
import dao.WrongMapper;
import org.springframework.beans.factory.annotation.Autowired;
import dao.SolveMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class SolveServiceImpl implements SolveService
{
    @Autowired
    private SolveMapper solveMapper;
    @Autowired
    private WrongMapper wrongMapper;
    
    @Override
    public List<Solve> selectall(final QueryVo vo) {
        final List<Solve> list = this.solveMapper.selectall(vo);
        return list;
    }
    
    @Override
    public Integer selectcount(final QueryVo vo) {
        final Integer count = this.solveMapper.selectcount(vo);
        return count;
    }
    
    @Override
    public void deletesolve(final Integer id) {
        this.solveMapper.deletesolve(id);
    }
    
    @Override
    public List<Wrong> findwrong(final QueryVo vo) {
        final List<Wrong> list = this.wrongMapper.findwrong(vo);
        return list;
    }
    
    @Override
    public Wrong findbyid(final Integer id) {
        final Wrong wrong = this.wrongMapper.findbyid(id);
        return wrong;
    }
    
    @Override
    public void insertwrong(final Wrong wrong) {
        wrong.setStatus("\u5f85\u5904\u7406");
        this.wrongMapper.insertwrong(wrong);
    }
    
    @Override
    public void gotosolve(final Integer id, final Solve solve) {
        this.solveMapper.insertsolve(solve);
        this.wrongMapper.deletewrong(id);
    }
}
