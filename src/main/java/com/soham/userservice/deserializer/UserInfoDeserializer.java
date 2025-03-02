package com.soham.userservice.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.soham.userservice.entities.UserInfoDto;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.serialization.Deserializer;

import java.nio.ByteBuffer;
import java.util.Map;

public class UserInfoDeserializer implements Deserializer<UserInfoDto> {

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {}

    @Override
    public UserInfoDto deserialize(String arg0, byte[] arg1) {
        ObjectMapper mapper = new ObjectMapper();
        UserInfoDto user = null;
        try{
            user = mapper.readValue(arg1, UserInfoDto.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public void close() {}
}
