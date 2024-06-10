package co.edu.uptc.control;

import javafx.scene.layout.GridPane;

public class HandlingConvert {
    public static String convert(String num, String op, GridPane binaryGrid, GridPane octalGrid, GridPane hexaGrid){
        switch(op){
            case "toBin":
                if(binaryGrid.isVisible()){
                    return num;
                }else if(octalGrid.isVisible()){
                    return octToBin(num);
                }else if(hexaGrid.isVisible()){
                    return hexToBin(num);
                }
            case "toOct":
                if(binaryGrid.isVisible()){
                    return binToOct(num);
                }else if(octalGrid.isVisible()){
                    return num;
                }else if(hexaGrid.isVisible()){
                    return hexToOct(num);
                }
            case "toHex":
                if(binaryGrid.isVisible()){
                    return binToHex(num);
                }else if(octalGrid.isVisible()){
                    return octToHex(num);
                }else if(hexaGrid.isVisible()){
                    return num;
                }
            default:
                return "WTF NIGGA";
        }
    }

    private static String binToOct(String num){
        Integer conv = Integer.parseInt(num, 2);
        return Integer.toString(conv, 8);
    }

    private static String binToHex(String num){
        Integer conv = Integer.parseInt(num, 2);
        return Integer.toString(conv, 16);
    }

    private static String octToBin(String num){
        Integer conv = Integer.parseInt(num, 8);
        return Integer.toString(conv, 2);
    }

    private static String octToHex(String num){
        Integer conv = Integer.parseInt(num, 8);
        return Integer.toString(conv, 16);
    }

    private static String hexToBin(String num){
        Integer conv = Integer.parseInt(num, 16);
        return Integer.toString(conv, 2);
    }

    private static String hexToOct(String num){
        Integer conv = Integer.parseInt(num, 16);
        return Integer.toString(conv, 8);
    }
}
