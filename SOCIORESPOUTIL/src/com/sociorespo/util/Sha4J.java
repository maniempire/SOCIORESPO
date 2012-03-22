/*
 * Sha4J implements SHA-1, SHA-224, SHA-256, SHA-384 and SHA-512 algorithms.
 *
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

import java.io.IOException;
import java.io.InputStream;
/**
 * Sha4J implements SHA-1, SHA-224, SHA-256, SHA-384 and SHA-512 algorithms.<br/>
 * 
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
public class Sha4J
{
  private boolean closeInputStream=true;
  
  public Sha4J()
  {
    this(true);
  }
  
  public Sha4J(boolean closeInputStream)  
  {
    this.closeInputStream=closeInputStream;
  }
  
  //Start SHA-1 implementation
  // variables and functions also used in other SHA
  // algorithms
  private long messageLength = 0;

  public byte[] sha1Digest(InputStream inputStream) throws IOException
  {
    // read bytes
    byte[] Mb = new byte[64];// 512-bit block
    int[] M = new int[16];
    int[] W = new int[80];

    // SHA-1 constants, digest initial value
    // Hash values
    int H0 = 0x67452301;
    int H1 = 0xefcdab89;
    int H2 = 0x98badcfe;
    int H3 = 0x10325476;
    int H4 = 0xc3d2e1f0;

    int[] H =
    { H0, H1, H2, H3, H4 };

    // read bytes from inputstream
    // and pad if necessary
    boolean padBlock = false;
    boolean padded = false;
    int bytesRead = inputStream.read(Mb, 0, 64);
    for (;;)
    {
      if (bytesRead == -1)
      {
        if (!padded)
        {
          doPadBlock(H, M, W, true);
        }

        byte[] digest = new byte[20];
        int i = 0;
        int j = 0;

        for (; j < 5; i += 4, j++)
        {
          digest[i] = (byte) (H[j] >>> 24);
          digest[i + 1] = (byte) (H[j] >>> 16);
          digest[i + 2] = (byte) (H[j] >>> 8);
          digest[i + 3] = (byte) (H[j]);
        }
        if(closeInputStream)
        {
          inputStream.close();
        }
        
        return digest;
      }  

      messageLength += (bytesRead << 3);// messageLength in bits,

      if (bytesRead < 55)
      {
        padded = true;
        // do padding if read bytes is smaller than 55 ==> total message length
        // can be added in this block as 64-bit value

        // add 1 after message
        Mb[bytesRead] = (byte) 0x80;
        for (int i = bytesRead + 1; i < 56; i++)
        {
          Mb[i] = 0;
        } 
        // add length as 64 bit value at the end of Mb
        addLength128(Mb);

      } 

      if (bytesRead == 55)
      {
        padded = true;

        // need to add totally new 512 bit block with all zeros except
        // last 64 bits which is message length
        Mb[55] = (byte) (0x80);
        addLength128(Mb);

      }

      if (bytesRead > 55 && bytesRead < 64)
      {
        padded = true;

        // need to add totally new 512 bit block with all zeros except
        // last 64 bits which is message length
        Mb[bytesRead] = (byte) 0x80;
        for (int i = bytesRead + 1; i < 64; i++)
        {
          Mb[i] = 0;
        }
        padBlock = true;// padBlock is 448-bits of zero + 64 bit length
      }

      // convert to int array. Java int is 32-bits
      // int is a 32-bit word in FIPS 180-2 specification
      int i = 0;
      int j = 0;
      for (; i < 16; j += 4, i++)
      {
        M[i] = (Mb[j] << 24) | (((Mb[j + 1]) & 0xff) << 16)
            | (((Mb[j + 2]) & 0xff) << 8) | ((Mb[j + 3]) & 0xff);
      }

      // prepare message schedule
      prepareMessageSchedule(M, W);

      // init working variables
      int a = H[0];// 1732584193;
      int b = H[1];// 4023233417;
      int c = H[2];// 2562383102;
      int d = H[3];// 271733878;
      int e = H[4];// 3285377520;

      int t = 0;
      for (; t < 80; t++)
      {
        int T = modulo32Add(modulo32Add(modulo32Add(ROTL(5, a), f(t, b, c, d)),
            modulo32Add(e, K(t))), W[t]);
        e = d;
        d = c;
        c = ROTL(30, b);
        b = a;
        a = T;

      }

      // interMediateHash128(H,a,b,c,d,e);
      H[0] = modulo32Add(H[0], a);
      H[1] = modulo32Add(H[1], b);
      H[2] = modulo32Add(H[2], c);
      H[3] = modulo32Add(H[3], d);
      H[4] = modulo32Add(H[4], e);

      // do last pad
      if (padBlock)
      {
        doPadBlock(H, M, W, false);
      } 

      bytesRead = inputStream.read(Mb, 0, 64);
    } 

  }

  private void addLength128(byte[] Mb)
  {
    Mb[56] = (byte) (messageLength >>> 56);
    Mb[57] = (byte) (messageLength >>> 48);
    Mb[58] = (byte) (messageLength >>> 40);
    Mb[59] = (byte) (messageLength >>> 32);
    Mb[60] = (byte) (messageLength >>> 24);
    Mb[61] = (byte) (messageLength >>> 16);
    Mb[62] = (byte) (messageLength >>> 8);
    Mb[63] = (byte) messageLength;
  }

  private void doPadBlock(int[] H, int[] M, int[] W, boolean addOne)
  {

    // addOne is the required 1 before
    M[0] = addOne ? 0x80000000 : 0;
    for (int i = 1; i < 14; i++)
    {
      M[i] = 0;
    }

    M[14] = (int) (messageLength >>> 32);
    M[15] = (int) messageLength;

    // prepare message schedule
    prepareMessageSchedule(M, W);

    // init working variables
    int a = H[0];// 1732584193;
    int b = H[1];// 4023233417;
    int c = H[2];// 2562383102;
    int d = H[3];// 271733878;
    int e = H[4];// 3285377520;

    int t = 0;
    for (; t < 80; t++)
    {
      int T = modulo32Add(modulo32Add(modulo32Add(ROTL(5, a), f(t, b, c, d)),
          modulo32Add(e, K(t))), W[t]);
      e = d;
      d = c;
      c = ROTL(30, b);
      b = a;
      a = T;

    }
    H[0] = modulo32Add(H[0], a);
    H[1] = modulo32Add(H[1], b);
    H[2] = modulo32Add(H[2], c);
    H[3] = modulo32Add(H[3], d);
    H[4] = modulo32Add(H[4], e);

  }

  private void prepareMessageSchedule(int[] M, int[] W)
  {
    for (int t = 0; t < 80; t++)
    {
      if (t < 16)
      {
        W[t] = M[t];
      } 
      else
      {
        W[t] = ROTL(1, W[t - 3] ^ W[t - 8] ^ W[t - 14] ^ W[t - 16]);
      } 

    } 
  }

  private int modulo32Add(int x, int y)
  {
    return (x ^ 0x80000000) + (y ^ 0x80000000); 
  }

  private int f(int t, int x, int y, int z)
  {
    if (t < 20)
    {
      return (x & y) ^ (~x & z);//Ch(x, y, z);
    }  
    if (t < 40)
    {
      return x ^ y ^ z;//Parity(x, y, z);
    }  
    if (t < 60)
    {
      return (x & y) ^ (x & z) ^ (y & z);//Maj(x, y, z);
    }  

    return x ^ y ^ z;//Parity(x, y, z);

  }

  private int Ch(int x, int y, int z)
  {
    return (x & y) ^ (~x & z);
  }
 
  private int Maj(int x, int y, int z)
  {
    return (x & y) ^ (x & z) ^ (y & z);
  }

  private int ROTL(int n, int x)
  {
    return (x << n) | (x >>> (32 - n));
  }

  private int K(int t)
  {

    if (t < 20)
    {
      return 0x5a827999;
    }  
    if (t < 40)
    {
      return 0x6ed9eba1;
    }  
    if (t < 60)
    {
      return 0x8f1bbcdc;
    }  

    return 0xca62c1d6;
  }

  // End SHA-1 implementation

  // Start SHA-224/SHA-256 implementation
  
  public byte[] sha224Digest(InputStream inputStream) throws IOException
  {
    return sha256Digest(inputStream,true);
  }

  public byte[] sha256Digest(InputStream inputStream) throws IOException
  {
    return sha256Digest(inputStream,false);
  }
  
  private byte[] sha256Digest(InputStream inputStream,boolean sha224) throws IOException
  {
    // read bytes
    byte[] Mb = new byte[64];// 512-bit block
    int[] M = new int[16];
    int[] W = new int[64];

    // SHA-256 constants, digest initial value

    int H0 = 0x6a09e667;
    int H1 = 0xbb67ae85;
    int H2 = 0x3c6ef372;
    int H3 = 0xa54ff53a;
    int H4 = 0x510e527f;
    int H5 = 0x9b05688c;
    int H6 = 0x1f83d9ab;
    int H7 = 0x5be0cd19;

    if(sha224)
    {
      H0=0xc1059ed8;      
      H1=0x367cd507;      
      H2=0x3070dd17;      
      H3=0xf70e5939;      
      H4=0xffc00b31;      
      H5=0x68581511;      
      H6=0x64f98fa7;      
      H7=0xbefa4fa4;            
    }
    
    
    int[] H =
    { H0, H1, H2, H3, H4, H5, H6, H7 };

    // read bytes from inputstream
    // and pad if necessary
    boolean padBlock = false;
    boolean padded = false;
    int bytesRead = inputStream.read(Mb, 0, 64);
    for (;;)
    {
      if (bytesRead == -1)
      {
        if (!padded)
        {
          doPadBlock256(H, M, W, true);
        }

        byte[] digest = new byte[32];
        int i = 0;
        int j = 0;
        for (; j < 8; i += 4, j++)
        {
          digest[i] = (byte) (H[j] >>> 24);
          digest[i + 1] = (byte) (H[j] >>> 16);
          digest[i + 2] = (byte) (H[j] >>> 8);
          digest[i + 3] = (byte) (H[j]);
        } 
        if(closeInputStream)
        {
          inputStream.close();
        }

        if(sha224)
        {
          byte[] digest2 = new byte[28];
          for (int k = 0; k < digest2.length; k++)
          {
            digest2[k] = digest[k];
          }
          return digest2;
        }
        return digest;
      }  

      messageLength += (bytesRead << 3);// messageLength in bits,

      if (bytesRead < 55)
      {
        padded = true;
        // do padding if read bytes is smaller than 55 ==> total message length
        // can be added in this block as 64-bit value

        // add 1 after message
        Mb[bytesRead] = (byte) 0x80;
        for (int i = bytesRead + 1; i < 56; i++)
        {
          Mb[i] = 0;
        }  
        // add length as 64 bit value at the end of Mb
        addLength128(Mb);

      }  

      if (bytesRead == 55)
      {
        padded = true;

        // need to add totally new 512 bit block with all zeros except
        // last 64 bits which is message length
        Mb[55] = (byte) (0x80);
        addLength128(Mb);

      }

      if (bytesRead > 55 && bytesRead < 64)
      {
        padded = true;

        // need to add totally new 512 bit block with all zeros except
        // last 64 bits which is message length
        Mb[bytesRead] = (byte) 0x80;
        for (int i = bytesRead + 1; i < 64; i++)
        {
          Mb[i] = 0;
        }  
        padBlock = true;// padBlock is 448-bits of zero + 64 bit length
      }

      // convert to int array. Java int is 32-bits
      // int is a 32-bit word in FIPS 180-2 specification
      int i = 0;
      int j = 0;
      for (; i < 16; j += 4, i++)
      {
        M[i] = (Mb[j] << 24) | (((Mb[j + 1]) & 0xff) << 16)
            | (((Mb[j + 2]) & 0xff) << 8) | ((Mb[j + 3]) & 0xff);

      }

      // prepare message schedule
      prepareMessageSchedule256(M, W);

      // init working variables
      int a = H[0];// 1732584193;
      int b = H[1];// 4023233417;
      int c = H[2];// 2562383102;
      int d = H[3];// 271733878;
      int e = H[4];// 3285377520;
      int f = H[5];// 3285377520;
      int g = H[6];// 3285377520;
      int h = H[7];// 3285377520;

      int t = 0;
      for (; t < 64; t++)
      {
        int T1 = modulo32Add(modulo32Add(modulo32Add(h, SIGMA256_1(e)),
            modulo32Add(Ch(e, f, g), K256[t])), W[t]);
        int T2 = modulo32Add(SIGMA256_0(a), Maj(a, b, c));
        h = g;
        g = f;
        f = e;
        e = modulo32Add(d, T1);
        d = c;
        c = b;
        b = a;
        a = modulo32Add(T1, T2);
      }  

      H[0] = modulo32Add(H[0], a);
      H[1] = modulo32Add(H[1], b);
      H[2] = modulo32Add(H[2], c);
      H[3] = modulo32Add(H[3], d);
      H[4] = modulo32Add(H[4], e);
      H[5] = modulo32Add(H[5], f);
      H[6] = modulo32Add(H[6], g);
      H[7] = modulo32Add(H[7], h);

      // do last pad
      if (padBlock)
      {
        doPadBlock256(H, M, W, false);
      }  

      bytesRead = inputStream.read(Mb, 0, 64);
    } 

  }

  private void doPadBlock256(int[] H, int[] M, int[] W, boolean addOne)
  {
    // addOne is the required 1 before
    M[0] = addOne ? 0x80000000 : 0;
    for (int i = 1; i < 14; i++)
    {
      M[i] = 0;
    }  

    M[14] = (int) (messageLength >>> 32);
    M[15] = (int) messageLength;

    // prepare message schedule
    prepareMessageSchedule256(M, W);

    // init working variables
    int a = H[0];// 1732584193;
    int b = H[1];// 4023233417;
    int c = H[2];// 2562383102;
    int d = H[3];// 271733878;
    int e = H[4];// 3285377520;
    int f = H[5];// 3285377520;
    int g = H[6];// 3285377520;
    int h = H[7];// 3285377520;

    int t = 0;
    int T1 = 0;
    int T2 = 0;
    for (; t < 64; t++)
    {
      T1 = modulo32Add(modulo32Add(modulo32Add(h, SIGMA256_1(e)), modulo32Add(
          Ch(e, f, g), K256[t])), W[t]);
      T2 = modulo32Add(SIGMA256_0(a), Maj(a, b, c));
      h = g;
      g = f;
      f = e;
      e = modulo32Add(d, T1);
      d = c;
      c = b;
      b = a;
      a = modulo32Add(T1, T2);
    }  

    H[0] = modulo32Add(H[0], a);
    H[1] = modulo32Add(H[1], b);
    H[2] = modulo32Add(H[2], c);
    H[3] = modulo32Add(H[3], d);
    H[4] = modulo32Add(H[4], e);
    H[5] = modulo32Add(H[5], f);
    H[6] = modulo32Add(H[6], g);
    H[7] = modulo32Add(H[7], h);

  }

  private static final int[] K256 =
  { 0x428a2f98, 0x71374491, 0xb5c0fbcf, 0xe9b5dba5, 0x3956c25b, 0x59f111f1,
      0x923f82a4, 0xab1c5ed5, 0xd807aa98, 0x12835b01, 0x243185be, 0x550c7dc3,
      0x72be5d74, 0x80deb1fe, 0x9bdc06a7, 0xc19bf174, 0xe49b69c1, 0xefbe4786,
      0x0fc19dc6, 0x240ca1cc, 0x2de92c6f, 0x4a7484aa, 0x5cb0a9dc, 0x76f988da,
      0x983e5152, 0xa831c66d, 0xb00327c8, 0xbf597fc7, 0xc6e00bf3, 0xd5a79147,
      0x06ca6351, 0x14292967, 0x27b70a85, 0x2e1b2138, 0x4d2c6dfc, 0x53380d13,
      0x650a7354, 0x766a0abb, 0x81c2c92e, 0x92722c85, 0xa2bfe8a1, 0xa81a664b,
      0xc24b8b70, 0xc76c51a3, 0xd192e819, 0xd6990624, 0xf40e3585, 0x106aa070,
      0x19a4c116, 0x1e376c08, 0x2748774c, 0x34b0bcb5, 0x391c0cb3, 0x4ed8aa4a,
      0x5b9cca4f, 0x682e6ff3, 0x748f82ee, 0x78a5636f, 0x84c87814, 0x8cc70208,
      0x90befffa, 0xa4506ceb, 0xbef9a3f7, 0xc67178f2 };

  private void prepareMessageSchedule256(int[] M, int[] W)
  {
    for (int t = 0; t < 64; t++)
    {

      if (t < 16)
      {
        W[t] = M[t];
      }  
      else
      {
        W[t] = modulo32Add(modulo32Add(sigma256_1(W[t - 2]), W[t - 7]),
            modulo32Add(sigma256_0(W[t - 15]), W[t - 16]));
      } 

    }  

  }

  private int SIGMA256_0(int x)
  {
    return ROTR(2,x) ^ ROTR(13,x) ^ ROTR(22,x);

  }


  private int SIGMA256_1(int x)
  {
    return ROTR(6,x) ^ ROTR(11,x) ^ ROTR(25,x);

  }


  private int sigma256_0(int x)
  {
    return ROTR(7,x) ^ ROTR(18,x) ^ SHR(3,x);

  }

  private int sigma256_1(int x)
  {
    return ROTR(17,x) ^ ROTR(19,x) ^ SHR(10,x);

  }

  private int ROTR(int n, int x)
  {
    return (x >>> n) | (x << (32 - n));

  }


  private int SHR(int n, int x)
  {
    return x >>> n;

  }


  // End SHA-224/256 implementation

  // Start SHA-512/384 implementation

  // SHA512 max length is 128bits
  private long messageLengthUpper = 0L;

  private long messageLengthLower = 0L;

  public byte[] sha384Digest(InputStream inputStream) throws IOException
  {
    return sha512Digest(inputStream, true);

  }

  public byte[] sha512Digest(InputStream inputStream) throws IOException
  {
    return sha512Digest(inputStream, false);
  }

  private byte[] sha512Digest(InputStream inputStream, boolean sha384)
      throws IOException
  {

    // read bytes
    byte[] Mb = new byte[128];// 1024-bit block
    long[] M = new long[16];
    long[] W = new long[80];

    // SHA-512 constants, digest initial value
    long H0 = 0x6a09e667f3bcc908L;
    long H1 = 0xbb67ae8584caa73bL;
    long H2 = 0x3c6ef372fe94f82bL;
    long H3 = 0xa54ff53a5f1d36f1L;
    long H4 = 0x510e527fade682d1L;
    long H5 = 0x9b05688c2b3e6c1fL;
    long H6 = 0x1f83d9abfb41bd6bL;
    long H7 = 0x5be0cd19137e2179L;
    if (sha384)
    {
      H0 = 0xcbbb9d5dc1059ed8L;
      H1 = 0x629a292a367cd507L;
      H2 = 0x9159015a3070dd17L;
      H3 = 0x152fecd8f70e5939L;
      H4 = 0x67332667ffc00b31L;
      H5 = 0x8eb44a8768581511L;
      H6 = 0xdb0c2e0d64f98fa7L;
      H7 = 0x47b5481dbefa4fa4L;
    }

    long[] H =
    { H0, H1, H2, H3, H4, H5, H6, H7 };

    // read bytes from inputstream
    // and pad if necessary
    boolean padBlock = false;
    boolean padded = false;
    int bytesRead = inputStream.read(Mb, 0, 128);
    for (;;)
    {
      if (bytesRead == -1)
      {
        if (!padded)
        {
          doPadBlock512(H, M, W, true);
        }

        byte[] digest = new byte[64];
        int i = 0;
        int j = 0;
        for (; j < 8; i += 8, j++)
        {
          digest[i] = (byte) (H[j] >>> 56);
          digest[i + 1] = (byte) (H[j] >>> 48);
          digest[i + 2] = (byte) (H[j] >>> 40);
          digest[i + 3] = (byte) (H[j] >>> 32);
          digest[i + 4] = (byte) (H[j] >>> 24);
          digest[i + 5] = (byte) (H[j] >>> 16);
          digest[i + 6] = (byte) (H[j] >>> 8);
          digest[i + 7] = (byte) (H[j]);

        }
        if(closeInputStream)
        {
          inputStream.close();
        }

        if (sha384)
        {
          byte[] digest2 = new byte[48];
          for (int k = 0; k < digest2.length; k++)
          {
            digest2[k] = digest[k];
          }
          return digest2;
        }

        return digest;
      }  

      messageLengthLower += (bytesRead << 3);// messageLength in bits,

      if (bytesRead < 110)
      {
        padded = true;
        // do padding if read bytes is smaller than 55 ==> total message length
        // can be added in this block as 64-bit value
        // add 1 after message
        Mb[bytesRead] = (byte) 0x80;
        for (int i = bytesRead + 1; i < 112; i++)
        {
          Mb[i] = 0;
        }  
        // add length as 128 bit value at the end of Mb
        addLength512(Mb);
      }  

      if (bytesRead == 110)
      {
        padded = true;

        // need to add totally new 512 bit block with all zeros except
        // last 64 bits which is message length
        Mb[110] = (byte) (0x80);
        addLength512(Mb);
      }

      if (bytesRead > 110 && bytesRead < 128)
      {
        padded = true;

        // need to add totally new 512 bit block with all zeros except
        // last 64 bits which is message length
        Mb[bytesRead] = (byte) 0x80;
        for (int i = bytesRead + 1; i < 128; i++)
        {
          Mb[i] = 0;
        }  
        padBlock = true;// padBlock is 896-bits of zero + 128 bit length
      }

      // convert to long array. Java long is 64-bits
      int i = 0;
      int j = 0;
      for (; i < 16; j += 8, i++)
      {

        M[i] = (((long) Mb[j]) << 56) | ((long) ((Mb[j + 1]) & 0xff) << 48)
            | ((long) ((Mb[j + 2]) & 0xff) << 40)
            | ((long) ((Mb[j + 3]) & 0xff) << 32)
            | ((long) ((Mb[j + 4]) & 0xff) << 24)
            | ((long) ((Mb[j + 5]) & 0xff) << 16)
            | ((long) ((Mb[j + 6]) & 0xff) << 8) | ((long) (Mb[j + 7]) & 0xff);
      }

      // prepare message schedule
      prepareMessageSchedule512(M, W);
      // init working variables
      long a = H[0];// 1732584193;
      long b = H[1];// 4023233417;
      long c = H[2];// 2562383102;
      long d = H[3];// 271733878;
      long e = H[4];// 3285377520;
      long f = H[5];// 3285377520;
      long g = H[6];// 3285377520;
      long h = H[7];// 3285377520;

      int t = 0;
      for (; t < 80; t++)
      {
        long T1 = modulo64Add(
                    modulo64Add(h, SIGMA512_1(e)), modulo64Add(modulo64Add(Ch(e, f, g),
                        K512[t]), W[t]));

        long T2 = modulo64Add(SIGMA512_0(a), Maj(a, b, c));

        h = g;
        g = f;
        f = e;
        e = modulo64Add(d, T1);
        d = c;
        c = b;
        b = a;
        a = modulo64Add(T1, T2);

      }  

      H[0] = modulo64Add(H[0], a);
      H[1] = modulo64Add(H[1], b);
      H[2] = modulo64Add(H[2], c);
      H[3] = modulo64Add(H[3], d);
      H[4] = modulo64Add(H[4], e);
      H[5] = modulo64Add(H[5], f);
      H[6] = modulo64Add(H[6], g);
      H[7] = modulo64Add(H[7], h);

      // do last pad
      if (padBlock)
      {
        doPadBlock512(H, M, W, false);
      }  

      bytesRead = inputStream.read(Mb, 0, 128);
    }  

  }

  private void doPadBlock512(long[] H, long[] M, long[] W, boolean addOne)
  {
    // addOne is the required 1 before
    M[0] = addOne ? 0x8000000000000000L : 0;
    for (int i = 1; i < 14; i++)
    {
      M[i] = 0;
    }  

    M[14] = messageLengthUpper;
    M[15] = messageLengthLower;

    // prepare message schedule
    prepareMessageSchedule512(M, W);

    // init working variables
    long a = H[0];// 1732584193;
    long b = H[1];// 4023233417;
    long c = H[2];// 2562383102;
    long d = H[3];// 271733878;
    long e = H[4];// 3285377520;
    long f = H[5];// 3285377520;
    long g = H[6];// 3285377520;
    long h = H[7];// 3285377520;

    int t = 0;
    long T1 = 0;
    long T2 = 0;
    for (; t < 80; t++)
    {
      T1 = modulo64Add(modulo64Add(modulo64Add(modulo64Add(h, SIGMA512_1(e)),
          Ch(e, f, g)), K512[t]), W[t]);
      T2 = modulo64Add(SIGMA512_0(a), Maj(a, b, c));
      h = g;
      g = f;
      f = e;
      e = modulo64Add(d, T1);
      d = c;
      c = b;
      b = a;
      a = modulo64Add(T1, T2);

    }  

    H[0] = modulo64Add(H[0], a);
    H[1] = modulo64Add(H[1], b);
    H[2] = modulo64Add(H[2], c);
    H[3] = modulo64Add(H[3], d);
    H[4] = modulo64Add(H[4], e);
    H[5] = modulo64Add(H[5], f);
    H[6] = modulo64Add(H[6], g);
    H[7] = modulo64Add(H[7], h);

  }

  private static final long[] K512 =
  { 0x428a2f98d728ae22L, 0x7137449123ef65cdL, 0xb5c0fbcfec4d3b2fL,
      0xe9b5dba58189dbbcL, 0x3956c25bf348b538L, 0x59f111f1b605d019L,
      0x923f82a4af194f9bL, 0xab1c5ed5da6d8118L, 0xd807aa98a3030242L,
      0x12835b0145706fbeL, 0x243185be4ee4b28cL, 0x550c7dc3d5ffb4e2L,
      0x72be5d74f27b896fL, 0x80deb1fe3b1696b1L, 0x9bdc06a725c71235L,
      0xc19bf174cf692694L, 0xe49b69c19ef14ad2L, 0xefbe4786384f25e3L,
      0x0fc19dc68b8cd5b5L, 0x240ca1cc77ac9c65L, 0x2de92c6f592b0275L,
      0x4a7484aa6ea6e483L, 0x5cb0a9dcbd41fbd4L, 0x76f988da831153b5L,
      0x983e5152ee66dfabL, 0xa831c66d2db43210L, 0xb00327c898fb213fL,
      0xbf597fc7beef0ee4L, 0xc6e00bf33da88fc2L, 0xd5a79147930aa725L,
      0x06ca6351e003826fL, 0x142929670a0e6e70L, 0x27b70a8546d22ffcL,
      0x2e1b21385c26c926L, 0x4d2c6dfc5ac42aedL, 0x53380d139d95b3dfL,
      0x650a73548baf63deL, 0x766a0abb3c77b2a8L, 0x81c2c92e47edaee6L,
      0x92722c851482353bL, 0xa2bfe8a14cf10364L, 0xa81a664bbc423001L,
      0xc24b8b70d0f89791L, 0xc76c51a30654be30L, 0xd192e819d6ef5218L,
      0xd69906245565a910L, 0xf40e35855771202aL, 0x106aa07032bbd1b8L,
      0x19a4c116b8d2d0c8L, 0x1e376c085141ab53L, 0x2748774cdf8eeb99L,
      0x34b0bcb5e19b48a8L, 0x391c0cb3c5c95a63L, 0x4ed8aa4ae3418acbL,
      0x5b9cca4f7763e373L, 0x682e6ff3d6b2b8a3L, 0x748f82ee5defb2fcL,
      0x78a5636f43172f60L, 0x84c87814a1f0ab72L, 0x8cc702081a6439ecL,
      0x90befffa23631e28L, 0xa4506cebde82bde9L, 0xbef9a3f7b2c67915L,
      0xc67178f2e372532bL, 0xca273eceea26619cL, 0xd186b8c721c0c207L,
      0xeada7dd6cde0eb1eL, 0xf57d4f7fee6ed178L, 0x06f067aa72176fbaL,
      0x0a637dc5a2c898a6L, 0x113f9804bef90daeL, 0x1b710b35131c471bL,
      0x28db77f523047d84L, 0x32caab7b40c72493L, 0x3c9ebe0a15c9bebcL,
      0x431d67c49c100d4cL, 0x4cc5d4becb3e42b6L, 0x597f299cfc657e2aL,
      0x5fcb6fab3ad6faecL, 0x6c44198c4a475817L };

  private long Ch(long x, long y, long z)
  {
    return (x & y) ^ (~x & z);

  }

  private long Maj(long x, long y, long z)
  {
    return (x & y) ^ (x & z) ^ (y & z);
  }

  private long SIGMA512_0(long x)
  {
    return ROTR(28, x) ^ ROTR(34, x) ^ ROTR(39, x);

  }

  private long SIGMA512_1(long x)
  {
    return ROTR(14, x) ^ ROTR(18, x) ^ ROTR(41, x);

  }

  private void prepareMessageSchedule512(long[] M, long[] W)
  {
    for (int t = 0; t < 80; t++)
    {
      if (t < 16)
      {
        W[t] = M[t];
      }
      else
      {

        W[t] = modulo64Add(modulo64Add(sigma512_1(W[t - 2]), W[t - 7]),
            modulo64Add(sigma512_0(W[t - 15]), W[t - 16]));

      }
    }
  }

  private long sigma512_0(long x)
  {
    return ROTR(1, x) ^ ROTR(8, x) ^ SHR(7, x);
  }

  private long sigma512_1(long x)
  {
    return ROTR(19, x) ^ ROTR(61, x) ^ SHR(6, x);
  }

  private long ROTR(int n, long x)
  {
    return (x >>> n) | (x << (64 - n));

  }

  private long SHR(int n, long x)
  {
    return x >>> n;

  }

  private long modulo64Add(long x, long y)
  {
    return (x ^ 0x8000000000000000L) + (y ^ 0x8000000000000000L);

  }

  private void addLength512(byte[] Mb)
  {
    Mb[112] = (byte) (messageLengthUpper >>> 56);
    Mb[113] = (byte) (messageLengthUpper >>> 48);
    Mb[114] = (byte) (messageLengthUpper >>> 40);
    Mb[115] = (byte) (messageLengthUpper >>> 32);
    Mb[116] = (byte) (messageLengthUpper >>> 24);
    Mb[117] = (byte) (messageLengthUpper >>> 16);
    Mb[118] = (byte) (messageLengthUpper >>> 8);
    Mb[119] = (byte) messageLengthUpper;

    Mb[120] = (byte) (messageLengthLower >>> 56);
    Mb[121] = (byte) (messageLengthLower >>> 48);
    Mb[122] = (byte) (messageLengthLower >>> 40);
    Mb[123] = (byte) (messageLengthLower >>> 32);
    Mb[124] = (byte) (messageLengthLower >>> 24);
    Mb[125] = (byte) (messageLengthLower >>> 16);
    Mb[126] = (byte) (messageLengthLower >>> 8);
    Mb[127] = (byte) messageLengthLower;

  }

  // ENd SHA-512 implementation

  /**
   * Resets instance for use in other operation. This must be
   * called before each consequent operation. If not called
   * results are not correct. 
   */
  public void reset()
  {
    // sha-1 variables
    this.messageLength = 0;

    // sha-512 variables
    this.messageLengthUpper = 0L;
    this.messageLengthLower = 0L;

  }
}
