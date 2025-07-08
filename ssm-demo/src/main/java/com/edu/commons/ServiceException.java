package com.edu.commons;

import lombok.Getter;

/**
 * @ProjectName: music-project
 * @Titile: ServiceException
 * @Author: Administrator
 * @Description: 业务异常
 */
public class ServiceException extends RuntimeException {
        //异常码
        @Getter //提高外部访问的getter访问器，外部就可以访问了
        private ServiceCode serviceCode;
        public ServiceException(ServiceCode serviceCode,String message ) {
            super(message);
            this.serviceCode = serviceCode;
        }

}
