package site.redis.socket;

import java.io.IOException;
import java.net.Socket;

public class JavaboyRedisClient {
    private Socket socket;
    public JavaboyRedisClient() {
        try {
            socket = new Socket("192.168.19.129", 6379);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Redis 连接失败");
        }
    }
    /**
     * 执行 Redis 中的 set 命令 [set,key,value]
     * @param key
     * @param value
     * @return
     */
    public String set(String key, String value) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("*3")
                .append("\r\n")
                .append("$")
                .append("set".length())
                .append("\r\n")
                .append("set")
                .append("\r\n")
                .append("$")
                .append(key.getBytes().length)
                .append("\r\n")
                .append(key)
                .append("\r\n")
                .append("$")
                .append(value.getBytes().length)
                .append("\r\n")
                .append(value)
                .append("\r\n");
        System.out.println(sb.toString());
        socket.getOutputStream().write(sb.toString().getBytes());
        byte[] buf = new byte[1024];
        socket.getInputStream().read(buf);
        return new String(buf);
    }
    /**
     * 执行 Redis 中的 get 命令 [get,key]
     * @param key
     * @return
     */
    public String get(String key) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("*2")
                .append("\r\n")
                .append("$")
                .append("get".length())
                .append("\r\n")
                .append("get")
                .append("\r\n")
                .append("$")
                .append(key.getBytes().length)
                .append("\r\n")
                .append(key)
                .append("\r\n");
        socket.getOutputStream().write(sb.toString().getBytes());
        byte[] buf = new byte[1024];
        socket.getInputStream().read(buf);
        return new String(buf);
    }

    public static void main(String[] args) throws IOException {
        String set = new JavaboyRedisClient().set("k1", "江南一点雨");
        System.out.println(set);
//        String k1 = new JavaboyRedisClient().get("k1");
//        System.out.println(k1);
    }
}
