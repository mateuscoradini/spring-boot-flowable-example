package br.com.coradini.springflowableexample;

import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.test.Deployment;
import org.flowable.spring.impl.test.FlowableSpringExtension;
import org.flowable.task.api.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@ExtendWith(FlowableSpringExtension.class)
@SpringBootTest
public class ArticleWorkflowIntegrationTest {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;


    @Test
    @Deployment(resources = {"processes/article-workflow.bpmn20.xml"})
    void articleApprovalTest() {
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("author", "test@coradini.com");
        variables.put("url", "http://coradini.com/dummy");
        runtimeService.startProcessInstanceByKey("articleReview", variables);
        Task task = taskService.createTaskQuery()
                .singleResult();
        assertEquals("Review the submitted tutorial", task.getName());
        variables.put("approved", true);
        taskService.complete(task.getId(), variables);
        assertEquals(0, runtimeService.createProcessInstanceQuery()
                .count());
    }
}