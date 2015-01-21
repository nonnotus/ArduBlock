package com.ardublock.translator.block.letsgoING;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class BTSerialPrintlnBlock extends TranslatorBlock
{
	public BTSerialPrintlnBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		//translator.addSetupCommand("Serial.begin(9600);");
		TranslatorBlock t1 = getRequiredTranslatorBlockAtSocket(0);
		String b1 = t1.toCode();
		
		String text = "";
		
		if (b1.equals("Return")) {

			text = "Serial.println( ";
			
        } else {

			text = "Serial.print( ";

		}			
		
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0, text , " );\n");
		
		String ret = translatorBlock.toCode();

	
		ret = ret + "Serial.println(\"\");\n";		
		
		return ret;
	}
}
