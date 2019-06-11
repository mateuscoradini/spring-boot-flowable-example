package br.com.coradini.flowable.example;

import br.com.coradini.flowable.example.service.PaymentService;
import lombok.extern.log4j.Log4j2;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.task.api.Task;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class FlowableExampleApplicationTests {


    private static final String ORDER_ID_PV = "orderId";
    private static final String ORDER_EMAIL_PV = "orderEmail";

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private TaskService taskService;


    @Test
    public void contextLoads() throws Exception {

        String orderId = "1";
        String orderEmail = "email@email.com";
        String processInstaceId = this.beginNewOrderEnrollment(orderId, orderEmail);
        log.info("Process instance ID: " + processInstaceId);
        Assert.assertNotNull(processInstaceId, "Process id should not be null.");

        // assync
        this.confirmEmail(orderId);

        // get outstading tasks
        List<Task> tasks = this.taskService
                .createTaskQuery()
                .taskName("newOrderTask")
                .includeProcessVariables()
                .processVariableValueEquals(ORDER_ID_PV, orderId)
                .list();

        Assert.assertTrue("There should be one outstading.", tasks.size() >= 1);

        //complete outstading tasks

        tasks.forEach(
                task -> {
                    this.taskService.claim(task.getId(), "coradini");
                    this.taskService.complete(task.getId());
                }
        );

        //Confirm the payment process
       Assert.assertEquals(this.paymentService.paymentConfirmations.get(orderEmail).toString(), new AtomicInteger(1).toString());

    }

    public String beginNewOrderEnrollment(String orderId, String orderEmail) {
        Map<String, Object> vars = new HashMap<>();
        vars.put(this.ORDER_ID_PV, orderId);
        vars.put(this.ORDER_EMAIL_PV, orderEmail);
        ProcessInstance instace = this.runtimeService.startProcessInstanceByKey("ecomerce-test-example", vars);
        return instace.getId();
    }

    private void confirmEmail(String orderId) {

    }

}
