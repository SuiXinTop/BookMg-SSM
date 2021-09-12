package com.ssm.service;

import com.ssm.domain.AdminInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xxx
 * @create 2021-09-12
 */

public interface AdminService {
   List<AdminInfo> selectAll();
}
