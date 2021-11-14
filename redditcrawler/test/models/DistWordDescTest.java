package models;

import com.fasterxml.jackson.databind.node.ArrayNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

/**
 * q class to get an list of distinctword descending and their corresponding number count
 * @author Ziran Cao
 * @version v1
 */
class DistWordDescTest {
    /**
     * test to get distinct words, search a random word in the api and check if the result size is bigger than 0
     * @author Ziran Cao
     * @version v1
     */
    @Test
    void desDistWdCount() {
        List<List<String>> arrayNode = new DistWordDesc().desDistWdCount("trump", 100);
        assertTrue(arrayNode.size()>0);
    }
}