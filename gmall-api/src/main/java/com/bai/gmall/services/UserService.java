package com.bai.gmall.services;

import com.bai.gmall.beans.UmsMember;
import com.bai.gmall.beans.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {
    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);
}
