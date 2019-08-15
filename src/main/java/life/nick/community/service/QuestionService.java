package life.nick.community.service;

import com.sun.scenario.effect.Offset;
import life.nick.community.dto.PaginationDTO;
import life.nick.community.dto.QuestionDTO;
import life.nick.community.mapper.QuestionMapper;
import life.nick.community.mapper.UserMapper;
import life.nick.community.model.Question;
import life.nick.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *@author lijing
 *@date 2019/8/11
 **/
@Service
public class QuestionService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    QuestionMapper questionMapper;

    public List<QuestionDTO> list(Integer offSet, Integer size) {
        List<Question> questionList = questionMapper.list(offSet,size);
        if (questionList == null) {
            return Collections.EMPTY_LIST;
        }
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questionList) {
            QuestionDTO questionDTO = new QuestionDTO();
            User user = userMapper.findById(question.getCreator());
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }

    /**
     * 获取分页数据
     * @return
     * @param page
     * @param size
     */
    public PaginationDTO listAll(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer offSet = (page-1)*size;
        List<QuestionDTO> questionDTOList = this.list(offSet,size);
        paginationDTO.setQuestionDTOList(questionDTOList);
        Integer total = questionMapper.count();
        paginationDTO.setPagination(total,page,size);
        return paginationDTO;
    }
}

