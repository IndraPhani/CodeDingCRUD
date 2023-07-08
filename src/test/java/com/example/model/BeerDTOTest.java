package com.example.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

/*/
Just to check the json flavor of the class and to learn the required test dependencies
It has nothing to do with the regular classes it is just to repeat the udemy classes.
 */
@JsonTest
public class BeerDTOTest extends BaseTest {
    @Autowired
    ObjectMapper objectMapper;
    Logger logger = LoggerFactory.getLogger(BeerDTOTest.class);

@Test
    void testSerializeDTO() throws JsonProcessingException {
    BeerDTO beerDTO = getBeerDTO();
    logger.info(objectMapper.writeValueAsString(beerDTO));
    System.out.println(objectMapper.writeValueAsString(beerDTO));
    }

}
