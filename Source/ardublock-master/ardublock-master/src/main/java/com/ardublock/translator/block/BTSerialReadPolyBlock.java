package com.ardublock.translator.block;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class BTSerialReadPolyBlock extends TranslatorBlock
{
	public BTSerialReadPolyBlock(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		//translator.addSetupCommand("\tSerial.begin(9600);");
		
		String ret = "Serial.read()";
		
		return codePrefix+ret+codeSuffix;
	}
}
