package com.ardublock.translator.block.letsgoING;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class AnalogGetStartButton3Block extends TranslatorBlock
{
	public AnalogGetStartButton3Block(Long blockId, Translator translator, String codePrefix,	String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	private final static String serialEventFunction = " AnalogButton Button1(1);\n";

	
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		
		 // Header hinzuf�gen
		translator.addHeaderFile("LGI_AnalogButton.h");
		
		
		// Deklarationen hinzuf�gen
		translator.addDefinitionCommand(serialEventFunction);

		String ret = "Button1.startButton();";
		

		return codePrefix + ret + codeSuffix;
	}
	
}