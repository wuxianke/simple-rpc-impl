package com.wu.rpc.transport.socket.util;

import com.wu.rpc.entity.RpcRequest;
import com.wu.rpc.enumeration.PackageType;
import com.wu.rpc.serializer.CommonSerializer;

import java.io.IOException;
import java.io.OutputStream;

/**
 * 通用的写工具类
 * @author Cactus
 */
public class ObjectWriter {
    private static final int MAGIC_NUMBER = 0xCAFEBABE;

    public static void writeObject(OutputStream outputStream, Object object, CommonSerializer serializer) throws IOException{
        outputStream.write(intToBytes(MAGIC_NUMBER));
        if(object instanceof RpcRequest){
            outputStream.write(intToBytes(PackageType.REQUEST_PACK.getCode()));
        }else{
            outputStream.write(intToBytes(PackageType.RESPONSE_PACK.getCode()));
        }
        outputStream.write(intToBytes(serializer.getCode()));
        byte[] bytes = serializer.serialize(object);
        outputStream.write(intToBytes(bytes.length));
        outputStream.write(bytes);
        outputStream.flush();
    }

    private static byte[] intToBytes(int magicNumber) {
        byte[] src = new byte[4];
        src[0] = (byte) ((magicNumber>>24) & 0xFF);
        src[1] = (byte) ((magicNumber>>16) & 0xFF);
        src[2] = (byte) ((magicNumber>>8) & 0xFF);
        src[3] = (byte) (magicNumber & 0xFF);
        return src;
    }
}
