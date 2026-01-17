package org.dromara.cdi.mmp.natdss.domain;

import org.dromara.common.mybatis.core.domain.BaseEntity;
import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serial;

/**
 * B04病历首页-核心信息-非中医院（基础+诊断+主要手术）对象 mmp_natdss_b04_medical_record_front_sheet_non_tcm
 *
 * @author LionLi
 * @date 2026-01-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("mmp_natdss_b04_medical_record_front_sheet_non_tcm")
public class MmpNatdssB04MedicalRecordFrontSheetNonTcm extends BaseEntity {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 患者ID
     */
    @TableId(value = "patient_id")
    private String patientId;

    /**
     * 单次就诊唯一标识号
     */
    @TableId(value = "visit_sn")
    private String visitSn;

    /**
     * 组织机构代码
     */
    private String a01;

    /**
     * 医疗机构名称
     */
    private String a02;

    /**
     * 病案号
     */
    private String a48;

    /**
     * 住院次数
     */
    private Long a49;

    /**
     * 入院时间
     */
    private Date b12;

    /**
     * 出院时间
     */
    private Date b15;

    /**
     * 健康卡号
     */
    private String a47;

    /**
     * 医疗付费方式
     */
    private String a46c;

    /**
     * 姓名
     */
    private String a11;

    /**
     * 性别
     */
    private Long a12c;

    /**
     * 出生日期
     */
    private Date a13;

    /**
     * 年龄(岁)
     */
    private Long a14;

    /**
     * 国籍
     */
    private String a15c;

    /**
     * 婚姻
     */
    private String a21c;

    /**
     * 职业
     */
    private String a38c;

    /**
     * 民族
     */
    private String a19c;

    /**
     * 身份证号
     */
    private String a20;

    /**
     * 出生地址
     */
    private String a22;

    /**
     * 籍贯省(自治区、直辖市)
     */
    private String a23c;

    /**
     * 户口地址
     */
    private String a24;

    /**
     * 户口地址邮政编码
     */
    private String a25c;

    /**
     * 现住址
     */
    private String a26;

    /**
     * 现住址电话
     */
    private String a27;

    /**
     * 现住址邮政编码
     */
    private String a28c;

    /**
     * 工作单位及地址
     */
    private String a29;

    /**
     * 工作单位电话
     */
    private String a30;

    /**
     * 工作单位邮政编码
     */
    private String a31c;

    /**
     * 联系人姓名
     */
    private String a32;

    /**
     * 联系人关系
     */
    private String a33c;

    /**
     * 联系人地址
     */
    private String a34;

    /**
     * 联系人电话
     */
    private String a35;

    /**
     * 入院途径
     */
    private String b11c;

    /**
     * 入院科别
     */
    private String b13c;

    /**
     * 入院病房
     */
    private String b14;

    /**
     * 转科科别
     */
    private String b21c;

    /**
     * 出院科别
     */
    private String b16c;

    /**
     * 出院病房
     */
    private String b17;

    /**
     * 实际住院(天)
     */
    private Long b20;

    /**
     * 门(急)诊诊断编码
     */
    private String c01c;

    /**
     * 门(急)诊诊断名称
     */
    private String c02n;

    /**
     * 出院主要诊断编码
     */
    private String c03c;

    /**
     * 出院主要诊断名称
     */
    private String c04n;

    /**
     * 出院主要诊断入院病情
     */
    private String c05c;

    /**
     * 出院其他诊断编码1
     */
    private String c06x01c;

    /**
     * 出院其他诊断名称1
     */
    private String c07x01n;

    /**
     * 出院其他诊断入院病情1
     */
    private String c08x01c;

    /**
     * 出院其他诊断编码2
     */
    private String c06x02c;

    /**
     * 出院其他诊断名称2
     */
    private String c07x02n;

    /**
     * 出院其他诊断入院病情2
     */
    private String c08x02c;

    /**
     * 出院其他诊断编码3
     */
    private String c06x03c;

    /**
     * 出院其他诊断名称3
     */
    private String c07x03n;

    /**
     * 出院其他诊断入院病情3
     */
    private String c08x03c;

    /**
     * 出院其他诊断编码4
     */
    private String c06x04c;

    /**
     * 出院其他诊断名称4
     */
    private String c07x04n;

    /**
     * 出院其他诊断入院病情4
     */
    private String c08x04c;

    /**
     * 出院其他诊断编码5
     */
    private String c06x05c;

    /**
     * 出院其他诊断名称5
     */
    private String c07x05n;

    /**
     * 出院其他诊断入院病情5
     */
    private String c08x05c;

    /**
     * 出院其他诊断编码6
     */
    private String c06x06c;

    /**
     * 出院其他诊断名称6
     */
    private String c07x06n;

    /**
     * 出院其他诊断入院病情6
     */
    private String c08x06c;

    /**
     * 出院其他诊断编码7
     */
    private String c06x07c;

    /**
     * 出院其他诊断名称7
     */
    private String c07x07n;

    /**
     * 出院其他诊断入院病情7
     */
    private String c08x07c;

    /**
     * 出院其他诊断编码8
     */
    private String c06x08c;

    /**
     * 出院其他诊断名称8
     */
    private String c07x08n;

    /**
     * 出院其他诊断入院病情8
     */
    private String c08x08c;

    /**
     * 出院其他诊断编码9
     */
    private String c06x09c;

    /**
     * 出院其他诊断名称9
     */
    private String c07x09n;

    /**
     * 出院其他诊断入院病情9
     */
    private String c08x09c;

    /**
     * 出院其他诊断编码10
     */
    private String c06x10c;

    /**
     * 出院其他诊断名称10
     */
    private String c07x10n;

    /**
     * 出院其他诊断入院病情10
     */
    private String c08x10c;

    /**
     * 出院其他诊断编码11
     */
    private String c06x11c;

    /**
     * 出院其他诊断名称11
     */
    private String c07x11n;

    /**
     * 出院其他诊断入院病情11
     */
    private String c08x11c;

    /**
     * 出院其他诊断编码12
     */
    private String c06x12c;

    /**
     * 出院其他诊断名称12
     */
    private String c07x12n;

    /**
     * 出院其他诊断入院病情12
     */
    private String c08x12c;

    /**
     * 出院其他诊断编码13
     */
    private String c06x13c;

    /**
     * 出院其他诊断名称13
     */
    private String c07x13n;

    /**
     * 出院其他诊断入院病情13
     */
    private String c08x13c;

    /**
     * 出院其他诊断编码14
     */
    private String c06x14c;

    /**
     * 出院其他诊断名称14
     */
    private String c07x14n;

    /**
     * 出院其他诊断入院病情14
     */
    private String c08x14c;

    /**
     * 出院其他诊断编码15
     */
    private String c06x15c;

    /**
     * 出院其他诊断名称15
     */
    private String c07x15n;

    /**
     * 出院其他诊断入院病情15
     */
    private String c08x15c;

    /**
     * 出院其他诊断编码16
     */
    private String c06x16c;

    /**
     * 出院其他诊断名称16
     */
    private String c07x16n;

    /**
     * 出院其他诊断入院病情16
     */
    private String c08x16c;

    /**
     * 出院其他诊断编码17
     */
    private String c06x17c;

    /**
     * 出院其他诊断名称17
     */
    private String c07x17n;

    /**
     * 出院其他诊断入院病情17
     */
    private String c08x17c;

    /**
     * 出院其他诊断编码18
     */
    private String c06x18c;

    /**
     * 出院其他诊断名称18
     */
    private String c07x18n;

    /**
     * 出院其他诊断入院病情18
     */
    private String c08x18c;

    /**
     * 出院其他诊断编码19
     */
    private String c06x19c;

    /**
     * 出院其他诊断名称19
     */
    private String c07x19n;

    /**
     * 出院其他诊断入院病情19
     */
    private String c08x19c;

    /**
     * 出院其他诊断编码20
     */
    private String c06x20c;

    /**
     * 出院其他诊断名称20
     */
    private String c07x20n;

    /**
     * 出院其他诊断入院病情20
     */
    private String c08x20c;

    /**
     * 出院其他诊断编码21
     */
    private String c06x21c;

    /**
     * 出院其他诊断名称21
     */
    private String c07x21n;

    /**
     * 出院其他诊断入院病情21
     */
    private String c08x21c;

    /**
     * 出院其他诊断编码22
     */
    private String c06x22c;

    /**
     * 出院其他诊断名称22
     */
    private String c07x22n;

    /**
     * 出院其他诊断入院病情22
     */
    private String c08x22c;

    /**
     * 出院其他诊断编码23
     */
    private String c06x23c;

    /**
     * 出院其他诊断名称23
     */
    private String c07x23n;

    /**
     * 出院其他诊断入院病情23
     */
    private String c08x23c;

    /**
     * 出院其他诊断编码24
     */
    private String c06x24c;

    /**
     * 出院其他诊断名称24
     */
    private String c07x24n;

    /**
     * 出院其他诊断入院病情24
     */
    private String c08x24c;

    /**
     * 出院其他诊断编码25
     */
    private String c06x25c;

    /**
     * 出院其他诊断名称25
     */
    private String c07x25n;

    /**
     * 出院其他诊断入院病情25
     */
    private String c08x25c;

    /**
     * 出院其他诊断编码26
     */
    private String c06x26c;

    /**
     * 出院其他诊断名称26
     */
    private String c07x26n;

    /**
     * 出院其他诊断入院病情26
     */
    private String c08x26c;

    /**
     * 出院其他诊断编码27
     */
    private String c06x27c;

    /**
     * 出院其他诊断名称27
     */
    private String c07x27n;

    /**
     * 出院其他诊断入院病情27
     */
    private String c08x27c;

    /**
     * 出院其他诊断编码28
     */
    private String c06x28c;

    /**
     * 出院其他诊断名称28
     */
    private String c07x28n;

    /**
     * 出院其他诊断入院病情28
     */
    private String c08x28c;

    /**
     * 出院其他诊断编码29
     */
    private String c06x29c;

    /**
     * 出院其他诊断名称29
     */
    private String c07x29n;

    /**
     * 出院其他诊断入院病情29
     */
    private String c08x29c;

    /**
     * 出院其他诊断编码30
     */
    private String c06x30c;

    /**
     * 出院其他诊断名称30
     */
    private String c07x30n;

    /**
     * 出院其他诊断入院病情30
     */
    private String c08x30c;

    /**
     * 出院其他诊断编码31
     */
    private String c06x31c;

    /**
     * 出院其他诊断名称31
     */
    private String c07x31n;

    /**
     * 出院其他诊断入院病情31
     */
    private String c08x31c;

    /**
     * 出院其他诊断编码32
     */
    private String c06x32c;

    /**
     * 出院其他诊断名称32
     */
    private String c07x32n;

    /**
     * 出院其他诊断入院病情32
     */
    private String c08x32c;

    /**
     * 出院其他诊断编码33
     */
    private String c06x33c;

    /**
     * 出院其他诊断名称33
     */
    private String c07x33n;

    /**
     * 出院其他诊断入院病情33
     */
    private String c08x33c;

    /**
     * 出院其他诊断编码34
     */
    private String c06x34c;

    /**
     * 出院其他诊断名称34
     */
    private String c07x34n;

    /**
     * 出院其他诊断入院病情34
     */
    private String c08x34c;

    /**
     * 出院其他诊断编码35
     */
    private String c06x35c;

    /**
     * 出院其他诊断名称35
     */
    private String c07x35n;

    /**
     * 出院其他诊断入院病情35
     */
    private String c08x35c;

    /**
     * 出院其他诊断编码36
     */
    private String c06x36c;

    /**
     * 出院其他诊断名称36
     */
    private String c07x36n;

    /**
     * 出院其他诊断入院病情36
     */
    private String c08x36c;

    /**
     * 出院其他诊断编码37
     */
    private String c06x37c;

    /**
     * 出院其他诊断名称37
     */
    private String c07x37n;

    /**
     * 出院其他诊断入院病情37
     */
    private String c08x37c;

    /**
     * 出院其他诊断编码38
     */
    private String c06x38c;

    /**
     * 出院其他诊断名称38
     */
    private String c07x38n;

    /**
     * 出院其他诊断入院病情38
     */
    private String c08x38c;

    /**
     * 出院其他诊断编码39
     */
    private String c06x39c;

    /**
     * 出院其他诊断名称39
     */
    private String c07x39n;

    /**
     * 出院其他诊断入院病情39
     */
    private String c08x39c;

    /**
     * 出院其他诊断编码40
     */
    private String c06x40c;

    /**
     * 出院其他诊断名称40
     */
    private String c07x40n;

    /**
     * 出院其他诊断入院病情40
     */
    private String c08x40c;

    /**
     * 病理诊断编码
     */
    private String c09c;

    /**
     * 病理诊断名称
     */
    private String c10n;

    /**
     * 病理号
     */
    private String c11;

    /**
     * 损伤、中毒外部原因编码
     */
    private String c12c;

    /**
     * 损伤、中毒外部原因名称
     */
    private String c13n;

    /**
     * 有无药物过敏
     */
    private String c24c;

    /**
     * 过敏药物名称
     */
    private String c25;

    /**
     * ABO血型
     */
    private String c26c;

    /**
     * Rh血型
     */
    private String c27c;

    /**
     * 死亡患者尸检
     */
    private String c34c;

    /**
     * 科主任
     */
    private String b22;

    /**
     * 主(副主)任医师
     */
    private String b23;

    /**
     * 主治医师
     */
    private String b24;

    /**
     * 住院医师
     */
    private String b25;

    /**
     * 责任护士
     */
    private String b26;

    /**
     * 进修医师
     */
    private String b27;

    /**
     * 实习医师
     */
    private String b28;

    /**
     * 编码员
     */
    private String b29;

    /**
     * 病案质量
     */
    private String b30c;

    /**
     * 质控医师
     */
    private String b31;

    /**
     * 质控护师
     */
    private String b32;

    /**
     * 质控日期
     */
    private Date b33;

    /**
     * 主要手术操作编码
     */
    private String c14x01c;

    /**
     * 主要手术操作名称
     */
    private String c15x01n;

    /**
     * 主要手术操作日期
     */
    private Date c16x01;

    /**
     * 主要手术操作级别
     */
    private String c17x01;

    /**
     * 主要手术操作术者
     */
    private String c18x01;

    /**
     * 主要手术操作Ⅰ助
     */
    private String c19x01;

    /**
     * 主要手术操作Ⅱ助
     */
    private String c20x01;

    /**
     * 主要手术操作切口愈合等级
     */
    private String c21x01c;

    /**
     * 主要手术操作麻醉方式
     */
    private String c22x01c;

    /**
     * 主要手术操作麻醉医师
     */
    private String c23x01;

    /**
     * 年龄不足1周岁的年龄(天)
     */
    private Long a16;

    /**
     * 新生儿出生体重(克)1
     */
    private Long a18x01;

    /**
     * 新生儿出生体重(克)2
     */
    private Long a18x02;

    /**
     * 新生儿出生体重(克)3
     */
    private Long a18x03;

    /**
     * 新生儿出生体重(克)4
     */
    private Long a18x04;

    /**
     * 新生儿出生体重(克)5
     */
    private Long a18x05;

    /**
     * 新生儿入院体重(克)
     */
    private Long a17;

    /**
     * 颅脑损伤患者入院前昏迷时间(天)
     */
    private Long c28;

    /**
     * 颅脑损伤患者入院前昏迷时间(小时)
     */
    private Long c29;

    /**
     * 颅脑损伤患者入院前昏迷时间(分钟)
     */
    private Long c30;

    /**
     * 颅脑损伤患者入院后昏迷时间(天)
     */
    private Long c31;

    /**
     * 颅脑损伤患者入院后昏迷时间(小时)
     */
    private Long c32;

    /**
     * 颅脑损伤患者入院后昏迷时间(分钟)
     */
    private Long c33;

    /**
     * 是否有出院31日内再住院计划
     */
    private Long b36c;

    /**
     * 出院31天再住院计划目的
     */
    private String b37;

    /**
     * 离院方式
     */
    private String b34c;

    /**
     * 医嘱转院、转社区卫生服务机构/乡镇卫生院名称
     */
    private String b35;

    /**
     * 主要手术操作编码2
     */
    private String c14x02c;

    /**
     * 主要手术操作名称2
     */
    private String c15x02n;

    /**
     * 主要手术操作日期2
     */
    private Date c16x02;

    /**
     * 主要手术操作级别2
     */
    private String c17x02;

    /**
     * 主要手术操作术者2
     */
    private String c18x02;

    /**
     * 主要手术操作Ⅰ助2
     */
    private String c19x02;

    /**
     * 主要手术操作Ⅱ助2
     */
    private String c20x02;

    /**
     * 主要手术操作切口愈合等级2
     */
    private String c21x02c;

    /**
     * 主要手术操作麻醉方式2
     */
    private String c22x02c;

    /**
     * 主要手术操作麻醉医师2
     */
    private String c23x02;

    /**
     * 主要手术操作编码3
     */
    private String c14x03c;

    /**
     * 主要手术操作名称3
     */
    private String c15x03n;

    /**
     * 主要手术操作日期3
     */
    private Date c16x03;

    /**
     * 主要手术操作级别3
     */
    private String c17x03;

    /**
     * 主要手术操作术者3
     */
    private String c18x03;

    /**
     * 主要手术操作Ⅰ助3
     */
    private String c19x03;

    /**
     * 主要手术操作Ⅱ助3
     */
    private String c20x03;

    /**
     * 主要手术操作切口愈合等级3
     */
    private String c21x03c;

    /**
     * 主要手术操作麻醉方式3
     */
    private String c22x03c;

    /**
     * 主要手术操作麻醉医师3
     */
    private String c23x03;

    /**
     * 主要手术操作编码4
     */
    private String c14x04c;

    /**
     * 主要手术操作名称4
     */
    private String c15x04n;

    /**
     * 主要手术操作日期4
     */
    private Date c16x04;

    /**
     * 主要手术操作级别4
     */
    private String c17x04;

    /**
     * 主要手术操作术者4
     */
    private String c18x04;

    /**
     * 主要手术操作Ⅰ助4
     */
    private String c19x04;

    /**
     * 主要手术操作Ⅱ助4
     */
    private String c20x04;

    /**
     * 主要手术操作切口愈合等级4
     */
    private String c21x04c;

    /**
     * 主要手术操作麻醉方式4
     */
    private String c22x04c;

    /**
     * 主要手术操作麻醉医师4
     */
    private String c23x04;

    /**
     * 主要手术操作编码5
     */
    private String c14x05c;

    /**
     * 主要手术操作名称5
     */
    private String c15x05n;

    /**
     * 主要手术操作日期5
     */
    private Date c16x05;

    /**
     * 主要手术操作级别5
     */
    private String c17x05;

    /**
     * 主要手术操作术者5
     */
    private String c18x05;

    /**
     * 主要手术操作Ⅰ助5
     */
    private String c19x05;

    /**
     * 主要手术操作Ⅱ助5
     */
    private String c20x05;

    /**
     * 主要手术操作切口愈合等级5
     */
    private String c21x05c;

    /**
     * 主要手术操作麻醉方式5
     */
    private String c22x05c;

    /**
     * 主要手术操作麻醉医师5
     */
    private String c23x05;

    /**
     * 主要手术操作编码6
     */
    private String c14x06c;

    /**
     * 主要手术操作名称6
     */
    private String c15x06n;

    /**
     * 主要手术操作日期6
     */
    private Date c16x06;

    /**
     * 主要手术操作级别6
     */
    private String c17x06;

    /**
     * 主要手术操作术者6
     */
    private String c18x06;

    /**
     * 主要手术操作Ⅰ助6
     */
    private String c19x06;

    /**
     * 主要手术操作Ⅱ助6
     */
    private String c20x06;

    /**
     * 主要手术操作切口愈合等级6
     */
    private String c21x06c;

    /**
     * 主要手术操作麻醉方式6
     */
    private String c22x06c;

    /**
     * 主要手术操作麻醉医师6
     */
    private String c23x06;

    /**
     * 主要手术操作编码7
     */
    private String c14x07c;

    /**
     * 主要手术操作名称7
     */
    private String c15x07n;

    /**
     * 主要手术操作日期7
     */
    private Date c16x07;

    /**
     * 主要手术操作级别7
     */
    private String c17x07;

    /**
     * 主要手术操作术者7
     */
    private String c18x07;

    /**
     * 主要手术操作Ⅰ助7
     */
    private String c19x07;

    /**
     * 主要手术操作Ⅱ助7
     */
    private String c20x07;

    /**
     * 主要手术操作切口愈合等级7
     */
    private String c21x07c;

    /**
     * 主要手术操作麻醉方式7
     */
    private String c22x07c;

    /**
     * 主要手术操作麻醉医师7
     */
    private String c23x07;

    /**
     * 主要手术操作编码8
     */
    private String c14x08c;

    /**
     * 主要手术操作名称8
     */
    private String c15x08n;

    /**
     * 主要手术操作日期8
     */
    private Date c16x08;

    /**
     * 主要手术操作级别8
     */
    private String c17x08;

    /**
     * 主要手术操作术者8
     */
    private String c18x08;

    /**
     * 主要手术操作Ⅰ助8
     */
    private String c19x08;

    /**
     * 主要手术操作Ⅱ助8
     */
    private String c20x08;

    /**
     * 主要手术操作切口愈合等级8
     */
    private String c21x08c;

    /**
     * 主要手术操作麻醉方式8
     */
    private String c22x08c;

    /**
     * 主要手术操作麻醉医师8
     */
    private String c23x08;

    /**
     * 主要手术操作编码9
     */
    private String c14x09c;

    /**
     * 主要手术操作名称9
     */
    private String c15x09n;

    /**
     * 主要手术操作日期9
     */
    private Date c16x09;

    /**
     * 主要手术操作级别9
     */
    private String c17x09;

    /**
     * 主要手术操作术者9
     */
    private String c18x09;

    /**
     * 主要手术操作Ⅰ助9
     */
    private String c19x09;

    /**
     * 主要手术操作Ⅱ助9
     */
    private String c20x09;

    /**
     * 主要手术操作切口愈合等级9
     */
    private String c21x09c;

    /**
     * 主要手术操作麻醉方式9
     */
    private String c22x09c;

    /**
     * 主要手术操作麻醉医师9
     */
    private String c23x09;

    /**
     * 主要手术操作编码10
     */
    private String c14x10c;

    /**
     * 主要手术操作名称10
     */
    private String c15x10n;

    /**
     * 主要手术操作日期10
     */
    private Date c16x10;

    /**
     * 主要手术操作级别10
     */
    private String c17x10;

    /**
     * 主要手术操作术者10
     */
    private String c18x10;

    /**
     * 主要手术操作Ⅰ助10
     */
    private String c19x10;

    /**
     * 主要手术操作Ⅱ助10
     */
    private String c20x10;

    /**
     * 主要手术操作切口愈合等级10
     */
    private String c21x10c;

    /**
     * 主要手术操作麻醉方式10
     */
    private String c22x10c;

    /**
     * 主要手术操作麻醉医师10
     */
    private String c23x10;


}
