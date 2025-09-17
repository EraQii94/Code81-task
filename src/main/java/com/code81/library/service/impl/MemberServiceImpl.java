package com.code81.library.service.impl;

import com.code81.library.dto.MemberRequestDTO;
import com.code81.library.dto.MemberResponseDTO;
import com.code81.library.entity.Member;
import com.code81.library.mapper.MemberMapper;
import com.code81.library.repository.MemberRepository;
import com.code81.library.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberMapper memberMapper;

    @Override
    public List<MemberResponseDTO> getAllMembers() {
        List<Member> members = memberRepository.findAll();
        return memberMapper.toDTOList(members);
    }

    @Override
    public MemberResponseDTO getMemberById(Long id) {
        Member member = memberRepository.findById(id).orElse(null);
        return memberMapper.toDTO(member);
    }

    @Override
    public MemberResponseDTO createMember(MemberRequestDTO memberRequestDTO) {
        Member member = memberMapper.toEntityFromRequest(memberRequestDTO);
        Member savedMember = memberRepository.save(member);
        return memberMapper.toDTO(savedMember);
    }

    @Override
    public MemberResponseDTO updateMember(Long id, MemberRequestDTO memberRequestDTO) {
        Member existingMember = memberRepository.findById(id).orElse(null);
        if (existingMember != null) {
            // Update fields
            existingMember.setFirstName(memberRequestDTO.getFirstName());
            existingMember.setLastName(memberRequestDTO.getLastName());
            existingMember.setEmail(memberRequestDTO.getEmail());
            existingMember.setPhoneNumber(memberRequestDTO.getPhoneNumber());
            existingMember.setAddress(memberRequestDTO.getAddress());
            existingMember.setMembershipDate(memberRequestDTO.getMembershipDate());
            
            Member updatedMember = memberRepository.save(existingMember);
            return memberMapper.toDTO(updatedMember);
        }
        return null;
    }

    @Override
    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }
}