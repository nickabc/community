package life.nick.community.service;

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

    public List<QuestionDTO> list() {
        List<Question> questionList = questionMapper.list();
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
}

