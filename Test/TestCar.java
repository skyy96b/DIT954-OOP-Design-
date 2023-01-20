package Test;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import org.junit.runner.RunWith;


public class TestCar {


    public static void main(String[] args){

    }


    @Test
    @ParameterizedTest
    @MethodSource("testValues")
    
    public void testMethod(int value){

        assert(value > 0);
    }
    

    public static Stream<Arguments> testValues(){
        return Stream.of(Arguments.of(1), Arguments.of(2));
    }

}
