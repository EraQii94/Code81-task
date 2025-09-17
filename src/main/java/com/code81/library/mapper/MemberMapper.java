package com.code81.library.mapper;

import com.code81.library.dto.MemberRequestDTO;
import com.code81.library.dto.MemberResponseDTO;
import com.code81.library.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper implements GenericMapper<Member, MemberResponseDTO> {

    @Override
    public MemberResponseDTO toDTO(Member member) {
        if (member == null) {
            return null;
        }

        MemberResponseDTO memberDTO = new MemberResponseDTO();
        memberDTO.setNID(member.getNID());
        memberDTO.setFirstName(member.getFirstName());
        memberDTO.setLastName(member.getLastName());
        memberDTO.setEmail(member.getEmail());
        memberDTO.setPhoneNumber(member.getPhoneNumber());
        memberDTO.setAddress(member.getAddress());
        memberDTO.setMembershipDate(member.getMembershipDate());

        return memberDTO;
    }

    @Override
    public Member toEntity(MemberResponseDTO memberDTO) {
        if (memberDTO == null) {
            return null;
        }

        Member member = new Member();
        member.setNID(memberDTO.getNID());
        member.setFirstName(memberDTO.getFirstName());
        member.setLastName(memberDTO.getLastName());
        member.setEmail(memberDTO.getEmail());
        member.setPhoneNumber(memberDTO.getPhoneNumber());
        member.setAddress(memberDTO.getAddress());
        member.setMembershipDate(memberDTO.getMembershipDate());

        return member;
    }

    public Member toEntityFromRequest(MemberRequestDTO memberRequestDTO) {
        if (memberRequestDTO == null) {
            return null;
        }

        Member member = new Member();
        member.setFirstName(memberRequestDTO.getFirstName());
        member.setLastName(memberRequestDTO.getLastName());
        member.setEmail(memberRequestDTO.getEmail());
        member.setPhoneNumber(memberRequestDTO.getPhoneNumber());
        member.setAddress(memberRequestDTO.getAddress());
        member.setMembershipDate(memberRequestDTO.getMembershipDate());

        return member;
    }

    @Override
    public java.util.List<MemberResponseDTO> toDTOList(java.util.List<Member> entityList) {
        return entityList.stream().map(this::toDTO).toList();
    }

    @Override
    public java.util.List<Member> toEntityList(java.util.List<MemberResponseDTO> dtoList) {
        return dtoList.stream().map(this::toEntity).toList();
    }
}