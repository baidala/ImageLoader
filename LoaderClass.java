/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loadimage;

/**
 *
 * @author student
 */
public class LoaderClass <InputType, OutputType>  implements Runnable{
    private InputType[] inArray;
    private OutputType result;
        
    
    LoaderClass (InputType[] inputArray) {
        this.inArray = inputArray;
    }

    @Override
    public void run() {
        for (InputType element:inArray) {
            System.out.printf("Load - %s\n" , element);
        }
        
        
    }
    
    OutputType returnResult () {
        return (OutputType) result;
    }
    
    public void beforeLoad(InputType[] inputArray) {
        for (InputType element:inputArray) {
            System.out.printf("Item - %s\n" , element);
        }
    }
    
    
}
