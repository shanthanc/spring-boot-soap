package com.shanthan.ibowebservice.endpoint;

import com.shanthan.ibowebservice.repository.IboRepository;
import com.shanthanc.ibo.GetIboRequest;
import com.shanthanc.ibo.GetIboResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class IboEndpoint {

    private static final String NAMESPACE_URI = "http://www.shanthanc.com/ibo";

    private IboRepository iboRepository;

    @Autowired
    public IboEndpoint(IboRepository iboRepository) {
        this.iboRepository = iboRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getIboRequest")
    @ResponsePayload
    public GetIboResponse getIboResponse(@RequestPayload GetIboRequest request) {
        GetIboResponse response = new GetIboResponse();
        response.setIbo(iboRepository.findIbo(request.getIboNumber()));
        return response;
    }
}
