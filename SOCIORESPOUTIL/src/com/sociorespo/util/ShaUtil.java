/*
 * Copyright (C) 2006 Softabar
 * 
 * This program is free software; you can redistribute it and/or modify it 
 * under the terms of the GNU General Public License as published by the 
 * Free Software Foundation; either version 2 of the License, or 
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License 
 * along with this program; if not, write to the 
 * Free Software Foundation, * Inc., * 59 Temple Place, * Suite 330, 
 * Boston, MA 02111-1307 USA
*/
package com.sociorespo.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Utility methods for Sha4J.<br/>
 * <pre>
 * Copyright (C) 2006 Softabar
 * 
 * This program is free software; you can redistribute it and/or modify it 
 * under the terms of the GNU General Public License as published by the 
 * Free Software Foundation; either version 2 of the License, or 
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the 
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License 
 * along with this program; if not, write to the 
 * Free Software Foundation, * Inc., * 59 Temple Place, * Suite 330, 
 * Boston, MA 02111-1307 USA
 * </pre>
 *
 * @version 1.0
 */
public class ShaUtil
{
  private static Sha4J sha4j=new Sha4J();
  //SHA-1
  
  public static byte[] sha1(String input) throws IOException
  {
    sha4j.reset();
    return sha4j.sha1Digest(new ByteArrayInputStream(input.getBytes()));
    
  }

  public static byte[] sha1(InputStream input) throws IOException
  {
    sha4j.reset();
    return sha4j.sha1Digest(input);
  }

  public static byte[] sha1(File input) throws IOException
  {
    sha4j.reset();
    FileInputStream fis=new FileInputStream(input);
    return sha4j.sha1Digest(fis);
  }

  public static String toSha1String(String input) throws IOException
  {
    return toHexString(sha1(input));
  }

  public static String toSha1String(InputStream input) throws IOException
  {
    return toHexString(sha1(input));
  }

  public static String toSha1String(File input) throws IOException
  {
    return toHexString(sha1(input));
  }

  //SHA-224
  
  public static byte[] sha224(String input) throws IOException
  {
    sha4j.reset();
    return sha4j.sha224Digest(new ByteArrayInputStream(input.getBytes()));
    
  }

  public static byte[] sha224(InputStream input) throws IOException
  {
    sha4j.reset();
    return sha4j.sha224Digest(input);
  }

  public static byte[] sha224(File input) throws IOException
  {
    sha4j.reset();
    FileInputStream fis=new FileInputStream(input);
    return sha4j.sha224Digest(fis);
  }

  public static String toSha224String(String input) throws IOException
  {
    return toHexString(sha224(input));
  }

  public static String toSha224String(InputStream input) throws IOException
  {
    return toHexString(sha224(input));
  }

  public static String toSha224String(File input) throws IOException
  {
    return toHexString(sha224(input));
  }
  
  
  //SHA-256
  
  public static byte[] sha256(String input) throws IOException
  {
    sha4j.reset();
    return sha4j.sha256Digest(new ByteArrayInputStream(input.getBytes()));
    
  }

  public static byte[] sha256(InputStream input) throws IOException
  {
    sha4j.reset();
    return sha4j.sha256Digest(input);
  }

  public static byte[] sha256(File input) throws IOException
  {
    sha4j.reset();
    FileInputStream fis=new FileInputStream(input);
    return sha4j.sha256Digest(fis);
  }

  public static String toSha256String(String input) throws IOException
  {
    return toHexString(sha256(input));
  }

  public static String toSha256String(InputStream input) throws IOException
  {
    return toHexString(sha256(input));
  }

  public static String toSha256String(File input) throws IOException
  {
    return toHexString(sha256(input));
  }

  //SHA-384
  
  public static byte[] sha384(String input) throws IOException
  {
    sha4j.reset();
    return sha4j.sha384Digest(new ByteArrayInputStream(input.getBytes()));
    
  }

  public static byte[] sha384(InputStream input) throws IOException
  {
    sha4j.reset();
    return sha4j.sha384Digest(input);
  }

  public static byte[] sha384(File input) throws IOException
  {
    sha4j.reset();
    FileInputStream fis=new FileInputStream(input);
    return sha4j.sha384Digest(fis);
  }

  public static String toSha384String(String input) throws IOException
  {
    return toHexString(sha384(input));
  }

  public static String toSha384String(InputStream input) throws IOException
  {
    return toHexString(sha384(input));
  }

  public static String toSha384String(File input) throws IOException
  {
    return toHexString(sha384(input));
  }
  
  //SHA-512
  public static byte[] sha512(String input) throws IOException
  {
    sha4j.reset();
    return sha4j.sha512Digest(new ByteArrayInputStream(input.getBytes()));
    
  }

  public static byte[] sha512(InputStream input) throws IOException
  {
    sha4j.reset();
    return sha4j.sha512Digest(input);
  }

  public static byte[] sha512(File input) throws IOException
  {
    sha4j.reset();
    FileInputStream fis=new FileInputStream(input);
    return sha4j.sha512Digest(fis);
  }

  public static String toSha512String(String input) throws IOException
  {
    return toHexString(sha512(input));
  }

  public static String toSha512String(InputStream input) throws IOException
  {
    return toHexString(sha512(input));
  }

  public static String toSha512String(File input) throws IOException
  {
    return toHexString(sha512(input));
  }
  

  
  
  // Display some bytes in HEX.

  private static final char[] hex =  { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
  
  /**
   * Convenience method to print byte array as hexadecimal string.
   * @param b Byte array to print.
   * @return Hexadecimal string presentation of byte array. 
   */
  public static String toHexString(byte[] b)
  {
    StringBuffer sb = new StringBuffer();

    for (int i = 0; i < b.length; i++)
    {
      int c = ((b[i]) >>> 4) & 0xf;
      sb.append(hex[c]);
      c = ((int) b[i] & 0xf);
      sb.append(hex[c]);
    }

    return sb.toString();
  }
}
