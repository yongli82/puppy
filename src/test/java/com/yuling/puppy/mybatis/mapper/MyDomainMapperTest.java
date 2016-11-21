package com.yuling.puppy.mybatis.mapper;

import com.yuling.puppy.PuppyApp;
import com.yuling.puppy.mybatis.domain.MyDomain;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

import static org.junit.Assert.*;


@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest(classes = PuppyApp.class)
@ActiveProfiles("dev")
@Transactional
public class MyDomainMapperTest {

    @Inject
    MyDomainMapper mapper;

    @Test
    @Commit
    public void insert() throws Exception {
        int row = mapper.insert("Hello", "world");
        assertEquals(1, row);
        MyDomain hello = mapper.findByName("Hello");
        assertNotNull(hello);
        assertEquals("world", hello.getType());
    }

}
