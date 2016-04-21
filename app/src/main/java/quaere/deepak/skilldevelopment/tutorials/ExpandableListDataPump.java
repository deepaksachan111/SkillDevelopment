package quaere.deepak.skilldevelopment.tutorials;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> introduction = new ArrayList<String>();
        introduction.add("Introduction");
        introduction.add("Advantages of C");

        List<String> example_of_c = new ArrayList<String>();
        example_of_c.add("Structure Of Program");

        List<String> variable_operator = new ArrayList<String>();
        variable_operator.add("Variables");
        variable_operator.add("Operators");

        List<String> input_output = new ArrayList<String>();
        input_output.add("Formatted IO-printf,scanf");
        input_output.add("Character IO-getchar,putchar");

        List<String> control_flow = new ArrayList<String>();
        control_flow.add("Conditional branching - if");
        control_flow.add("Conditional Selection - switch");
        control_flow.add("Loops - while,for");
      /*  control_flow.add("Local Jumps goto");*/
        control_flow.add("Break and Continue");

        List<String> functions = new ArrayList<String>();
        functions.add("Function Basics");
        functions.add("Defination and Declaration");
        functions.add("Standard Header files");


        List<String> scope_block_variable = new ArrayList<String>();
        scope_block_variable.add("Block and Scopes");
        scope_block_variable.add("Variable Storage Classes");
        scope_block_variable.add("Definition vs Declaration");
      /*  scope_block_variable.add("Initialisation of Variables");*/


        List<String> array_pointer_string = new ArrayList<String>();
        array_pointer_string.add("Arrays");
        array_pointer_string.add("Pointer");
        array_pointer_string.add("String");

        List<String> structure_union = new ArrayList<String>();
        structure_union.add("Structures");
        structure_union.add("Unions");

        List<String> files = new ArrayList<String>();
        files.add("File Operation and functions");

        List<String> preprocessor = new ArrayList<String>();
        preprocessor.add("Preprocessor Directives");


        expandableListDetail.put("Variables & Operators", variable_operator);
        expandableListDetail.put("Input and Output", input_output);

        expandableListDetail.put("Flow of Control", control_flow);
        expandableListDetail.put("Introduction", introduction);
        expandableListDetail.put("Functions", functions);

        expandableListDetail.put("An Example of C", example_of_c);
        expandableListDetail.put("Scope, Block & Variables", scope_block_variable);
        expandableListDetail.put("Array,Pointer & String", array_pointer_string);
        expandableListDetail.put("Structure & Union", structure_union);
         expandableListDetail.put("Files", files);
         expandableListDetail.put("Preprocessor Directives", preprocessor);
        return expandableListDetail;
    }
}
