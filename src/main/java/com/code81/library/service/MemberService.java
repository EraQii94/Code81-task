package com.code81.library.service;

import com.code81.library.dto.MemberRequestDTO;
import com.code81.library.dto.MemberResponseDTO;
import java.util.List;

public interface MemberService {
    List<MemberResponseDTO> getAllMembers();
    MemberResponseDTO getMemberById(Long id);
    MemberResponseDTO createMember(MemberRequestDTO memberRequestDTO);
    MemberResponseDTO updateMember(Long id, MemberRequestDTO memberRequestDTO);
    void deleteMember(Long id);
}