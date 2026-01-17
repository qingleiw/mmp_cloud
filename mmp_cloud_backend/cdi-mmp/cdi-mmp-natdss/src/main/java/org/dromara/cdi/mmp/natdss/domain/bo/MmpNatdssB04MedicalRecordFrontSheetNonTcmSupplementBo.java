package org.dromara.cdi.mmp.natdss.domain.bo;

import org.dromara.cdi.mmp.natdss.domain.MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement;
import org.dromara.common.mybatis.core.domain.BaseEntity;
import org.dromara.common.core.validate.AddGroup;
import org.dromara.common.core.validate.EditGroup;
import io.github.linpeilie.annotations.AutoMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;
import jakarta.validation.constraints.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * B04非中医院-补充信息（其他手术+费用+扩展信息）业务对象 mmp_natdss_b04_medical_record_front_sheet_non_tcm_supplement
 *
 * @author LionLi
 * @date 2026-01-18
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AutoMapper(target = MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplement.class, reverseConvertGenerate = false)
public class MmpNatdssB04MedicalRecordFrontSheetNonTcmSupplementBo extends BaseEntity {

    /**
     * 患者ID
     */
    @NotBlank(message = "患者ID不能为空", groups = { EditGroup.class })
    private String patientId;

    /**
     * 单次就诊唯一标识号
     */
    @NotBlank(message = "单次就诊唯一标识号不能为空", groups = { EditGroup.class })
    private String visitSn;

    /**
     * 其他手术操作编码1
     */
    private String c35x01c;

    /**
     * 其他手术操作名称1
     */
    private String c36x01n;

    /**
     * 其他手术操作日期1
     */
    private Date c37x01;

    /**
     * 其他手术操作级别1
     */
    private String c38x01;

    /**
     * 其他手术操作术者1
     */
    private String c39x01;

    /**
     * 其他手术操作Ⅰ助1
     */
    private String c40x01;

    /**
     * 其他手术操作Ⅱ助1
     */
    private String c41x01;

    /**
     * 其他手术操作切口愈合等级1
     */
    private String c42x01c;

    /**
     * 其他手术操作麻醉方式1
     */
    private String c43x01c;

    /**
     * 其他手术操作麻醉医师1
     */
    private String c44x01;

    /**
     * 其他手术操作编码2
     */
    private String c35x02c;

    /**
     * 其他手术操作名称2
     */
    private String c36x02n;

    /**
     * 其他手术操作日期2
     */
    private Date c37x02;

    /**
     * 其他手术操作级别2
     */
    private String c38x02;

    /**
     * 其他手术操作术者2
     */
    private String c39x02;

    /**
     * 其他手术操作Ⅰ助2
     */
    private String c40x02;

    /**
     * 其他手术操作Ⅱ助2
     */
    private String c41x02;

    /**
     * 其他手术操作切口愈合等级2
     */
    private String c42x02c;

    /**
     * 其他手术操作麻醉方式2
     */
    private String c43x02c;

    /**
     * 其他手术操作麻醉医师2
     */
    private String c44x02;

    /**
     * 其他手术操作编码3
     */
    private String c35x03c;

    /**
     * 其他手术操作名称3
     */
    private String c36x03n;

    /**
     * 其他手术操作日期3
     */
    private Date c37x03;

    /**
     * 其他手术操作级别3
     */
    private String c38x03;

    /**
     * 其他手术操作术者3
     */
    private String c39x03;

    /**
     * 其他手术操作Ⅰ助3
     */
    private String c40x03;

    /**
     * 其他手术操作Ⅱ助3
     */
    private String c41x03;

    /**
     * 其他手术操作切口愈合等级3
     */
    private String c42x03c;

    /**
     * 其他手术操作麻醉方式3
     */
    private String c43x03c;

    /**
     * 其他手术操作麻醉医师3
     */
    private String c44x03;

    /**
     * 其他手术操作编码4
     */
    private String c35x04c;

    /**
     * 其他手术操作名称4
     */
    private String c36x04n;

    /**
     * 其他手术操作日期4
     */
    private Date c37x04;

    /**
     * 其他手术操作级别4
     */
    private String c38x04;

    /**
     * 其他手术操作术者4
     */
    private String c39x04;

    /**
     * 其他手术操作Ⅰ助4
     */
    private String c40x04;

    /**
     * 其他手术操作Ⅱ助4
     */
    private String c41x04;

    /**
     * 其他手术操作切口愈合等级4
     */
    private String c42x04c;

    /**
     * 其他手术操作麻醉方式4
     */
    private String c43x04c;

    /**
     * 其他手术操作麻醉医师4
     */
    private String c44x04;

    /**
     * 其他手术操作编码5
     */
    private String c35x05c;

    /**
     * 其他手术操作名称5
     */
    private String c36x05n;

    /**
     * 其他手术操作日期5
     */
    private Date c37x05;

    /**
     * 其他手术操作级别5
     */
    private String c38x05;

    /**
     * 其他手术操作术者5
     */
    private String c39x05;

    /**
     * 其他手术操作Ⅰ助5
     */
    private String c40x05;

    /**
     * 其他手术操作Ⅱ助5
     */
    private String c41x05;

    /**
     * 其他手术操作切口愈合等级5
     */
    private String c42x05c;

    /**
     * 其他手术操作麻醉方式5
     */
    private String c43x05c;

    /**
     * 其他手术操作麻醉医师5
     */
    private String c44x05;

    /**
     * 其他手术操作编码6
     */
    private String c35x06c;

    /**
     * 其他手术操作名称6
     */
    private String c36x06n;

    /**
     * 其他手术操作日期6
     */
    private Date c37x06;

    /**
     * 其他手术操作级别6
     */
    private String c38x06;

    /**
     * 其他手术操作术者6
     */
    private String c39x06;

    /**
     * 其他手术操作Ⅰ助6
     */
    private String c40x06;

    /**
     * 其他手术操作Ⅱ助6
     */
    private String c41x06;

    /**
     * 其他手术操作切口愈合等级6
     */
    private String c42x06c;

    /**
     * 其他手术操作麻醉方式6
     */
    private String c43x06c;

    /**
     * 其他手术操作麻醉医师6
     */
    private String c44x06;

    /**
     * 其他手术操作编码7
     */
    private String c35x07c;

    /**
     * 其他手术操作名称7
     */
    private String c36x07n;

    /**
     * 其他手术操作日期7
     */
    private Date c37x07;

    /**
     * 其他手术操作级别7
     */
    private String c38x07;

    /**
     * 其他手术操作术者7
     */
    private String c39x07;

    /**
     * 其他手术操作Ⅰ助7
     */
    private String c40x07;

    /**
     * 其他手术操作Ⅱ助7
     */
    private String c41x07;

    /**
     * 其他手术操作切口愈合等级7
     */
    private String c42x07c;

    /**
     * 其他手术操作麻醉方式7
     */
    private String c43x07c;

    /**
     * 其他手术操作麻醉医师7
     */
    private String c44x07;

    /**
     * 其他手术操作编码8
     */
    private String c35x08c;

    /**
     * 其他手术操作名称8
     */
    private String c36x08n;

    /**
     * 其他手术操作日期8
     */
    private Date c37x08;

    /**
     * 其他手术操作级别8
     */
    private String c38x08;

    /**
     * 其他手术操作术者8
     */
    private String c39x08;

    /**
     * 其他手术操作Ⅰ助8
     */
    private String c40x08;

    /**
     * 其他手术操作Ⅱ助8
     */
    private String c41x08;

    /**
     * 其他手术操作切口愈合等级8
     */
    private String c42x08c;

    /**
     * 其他手术操作麻醉方式8
     */
    private String c43x08c;

    /**
     * 其他手术操作麻醉医师8
     */
    private String c44x08;

    /**
     * 其他手术操作编码9
     */
    private String c35x09c;

    /**
     * 其他手术操作名称9
     */
    private String c36x09n;

    /**
     * 其他手术操作日期9
     */
    private Date c37x09;

    /**
     * 其他手术操作级别9
     */
    private String c38x09;

    /**
     * 其他手术操作术者9
     */
    private String c39x09;

    /**
     * 其他手术操作Ⅰ助9
     */
    private String c40x09;

    /**
     * 其他手术操作Ⅱ助9
     */
    private String c41x09;

    /**
     * 其他手术操作切口愈合等级9
     */
    private String c42x09c;

    /**
     * 其他手术操作麻醉方式9
     */
    private String c43x09c;

    /**
     * 其他手术操作麻醉医师9
     */
    private String c44x09;

    /**
     * 其他手术操作编码10
     */
    private String c35x10c;

    /**
     * 其他手术操作名称10
     */
    private String c36x10n;

    /**
     * 其他手术操作日期10
     */
    private Date c37x10;

    /**
     * 其他手术操作级别10
     */
    private String c38x10;

    /**
     * 其他手术操作术者10
     */
    private String c39x10;

    /**
     * 其他手术操作Ⅰ助10
     */
    private String c40x10;

    /**
     * 其他手术操作Ⅱ助10
     */
    private String c41x10;

    /**
     * 其他手术操作切口愈合等级10
     */
    private String c42x10c;

    /**
     * 其他手术操作麻醉方式10
     */
    private String c43x10c;

    /**
     * 其他手术操作麻醉医师10
     */
    private String c44x10;

    /**
     * 其他手术操作编码11
     */
    private String c35x11c;

    /**
     * 其他手术操作名称11
     */
    private String c36x11n;

    /**
     * 其他手术操作日期11
     */
    private Date c37x11;

    /**
     * 其他手术操作级别11
     */
    private String c38x11;

    /**
     * 其他手术操作术者11
     */
    private String c39x11;

    /**
     * 其他手术操作Ⅰ助11
     */
    private String c40x11;

    /**
     * 其他手术操作Ⅱ助11
     */
    private String c41x11;

    /**
     * 其他手术操作切口愈合等级11
     */
    private String c42x11c;

    /**
     * 其他手术操作麻醉方式11
     */
    private String c43x11c;

    /**
     * 其他手术操作麻醉医师11
     */
    private String c44x11;

    /**
     * 其他手术操作编码12
     */
    private String c35x12c;

    /**
     * 其他手术操作名称12
     */
    private String c36x12n;

    /**
     * 其他手术操作日期12
     */
    private Date c37x12;

    /**
     * 其他手术操作级别12
     */
    private String c38x12;

    /**
     * 其他手术操作术者12
     */
    private String c39x12;

    /**
     * 其他手术操作Ⅰ助12
     */
    private String c40x12;

    /**
     * 其他手术操作Ⅱ助12
     */
    private String c41x12;

    /**
     * 其他手术操作切口愈合等级12
     */
    private String c42x12c;

    /**
     * 其他手术操作麻醉方式12
     */
    private String c43x12c;

    /**
     * 其他手术操作麻醉医师12
     */
    private String c44x12;

    /**
     * 其他手术操作编码13
     */
    private String c35x13c;

    /**
     * 其他手术操作名称13
     */
    private String c36x13n;

    /**
     * 其他手术操作日期13
     */
    private Date c37x13;

    /**
     * 其他手术操作级别13
     */
    private String c38x13;

    /**
     * 其他手术操作术者13
     */
    private String c39x13;

    /**
     * 其他手术操作Ⅰ助13
     */
    private String c40x13;

    /**
     * 其他手术操作Ⅱ助13
     */
    private String c41x13;

    /**
     * 其他手术操作切口愈合等级13
     */
    private String c42x13c;

    /**
     * 其他手术操作麻醉方式13
     */
    private String c43x13c;

    /**
     * 其他手术操作麻醉医师13
     */
    private String c44x13;

    /**
     * 其他手术操作编码14
     */
    private String c35x14c;

    /**
     * 其他手术操作名称14
     */
    private String c36x14n;

    /**
     * 其他手术操作日期14
     */
    private Date c37x14;

    /**
     * 其他手术操作级别14
     */
    private String c38x14;

    /**
     * 其他手术操作术者14
     */
    private String c39x14;

    /**
     * 其他手术操作Ⅰ助14
     */
    private String c40x14;

    /**
     * 其他手术操作Ⅱ助14
     */
    private String c41x14;

    /**
     * 其他手术操作切口愈合等级14
     */
    private String c42x14c;

    /**
     * 其他手术操作麻醉方式14
     */
    private String c43x14c;

    /**
     * 其他手术操作麻醉医师14
     */
    private String c44x14;

    /**
     * 其他手术操作编码15
     */
    private String c35x15c;

    /**
     * 其他手术操作名称15
     */
    private String c36x15n;

    /**
     * 其他手术操作日期15
     */
    private Date c37x15;

    /**
     * 其他手术操作级别15
     */
    private String c38x15;

    /**
     * 其他手术操作术者15
     */
    private String c39x15;

    /**
     * 其他手术操作Ⅰ助15
     */
    private String c40x15;

    /**
     * 其他手术操作Ⅱ助15
     */
    private String c41x15;

    /**
     * 其他手术操作切口愈合等级15
     */
    private String c42x15c;

    /**
     * 其他手术操作麻醉方式15
     */
    private String c43x15c;

    /**
     * 其他手术操作麻醉医师15
     */
    private String c44x15;

    /**
     * 其他手术操作编码16
     */
    private String c35x16c;

    /**
     * 其他手术操作名称16
     */
    private String c36x16n;

    /**
     * 其他手术操作日期16
     */
    private Date c37x16;

    /**
     * 其他手术操作级别16
     */
    private String c38x16;

    /**
     * 其他手术操作术者16
     */
    private String c39x16;

    /**
     * 其他手术操作Ⅰ助16
     */
    private String c40x16;

    /**
     * 其他手术操作Ⅱ助16
     */
    private String c41x16;

    /**
     * 其他手术操作切口愈合等级16
     */
    private String c42x16c;

    /**
     * 其他手术操作麻醉方式16
     */
    private String c43x16c;

    /**
     * 其他手术操作麻醉医师16
     */
    private String c44x16;

    /**
     * 其他手术操作编码17
     */
    private String c35x17c;

    /**
     * 其他手术操作名称17
     */
    private String c36x17n;

    /**
     * 其他手术操作日期17
     */
    private Date c37x17;

    /**
     * 其他手术操作级别17
     */
    private String c38x17;

    /**
     * 其他手术操作术者17
     */
    private String c39x17;

    /**
     * 其他手术操作Ⅰ助17
     */
    private String c40x17;

    /**
     * 其他手术操作Ⅱ助17
     */
    private String c41x17;

    /**
     * 其他手术操作切口愈合等级17
     */
    private String c42x17c;

    /**
     * 其他手术操作麻醉方式17
     */
    private String c43x17c;

    /**
     * 其他手术操作麻醉医师17
     */
    private String c44x17;

    /**
     * 其他手术操作编码18
     */
    private String c35x18c;

    /**
     * 其他手术操作名称18
     */
    private String c36x18n;

    /**
     * 其他手术操作日期18
     */
    private Date c37x18;

    /**
     * 其他手术操作级别18
     */
    private String c38x18;

    /**
     * 其他手术操作术者18
     */
    private String c39x18;

    /**
     * 其他手术操作Ⅰ助18
     */
    private String c40x18;

    /**
     * 其他手术操作Ⅱ助18
     */
    private String c41x18;

    /**
     * 其他手术操作切口愈合等级18
     */
    private String c42x18c;

    /**
     * 其他手术操作麻醉方式18
     */
    private String c43x18c;

    /**
     * 其他手术操作麻醉医师18
     */
    private String c44x18;

    /**
     * 其他手术操作编码19
     */
    private String c35x19c;

    /**
     * 其他手术操作名称19
     */
    private String c36x19n;

    /**
     * 其他手术操作日期19
     */
    private Date c37x19;

    /**
     * 其他手术操作级别19
     */
    private String c38x19;

    /**
     * 其他手术操作术者19
     */
    private String c39x19;

    /**
     * 其他手术操作Ⅰ助19
     */
    private String c40x19;

    /**
     * 其他手术操作Ⅱ助19
     */
    private String c41x19;

    /**
     * 其他手术操作切口愈合等级19
     */
    private String c42x19c;

    /**
     * 其他手术操作麻醉方式19
     */
    private String c43x19c;

    /**
     * 其他手术操作麻醉医师19
     */
    private String c44x19;

    /**
     * 其他手术操作编码20
     */
    private String c35x20c;

    /**
     * 其他手术操作名称20
     */
    private String c36x20n;

    /**
     * 其他手术操作日期20
     */
    private Date c37x20;

    /**
     * 其他手术操作级别20
     */
    private String c38x20;

    /**
     * 其他手术操作术者20
     */
    private String c39x20;

    /**
     * 其他手术操作Ⅰ助20
     */
    private String c40x20;

    /**
     * 其他手术操作Ⅱ助20
     */
    private String c41x20;

    /**
     * 其他手术操作切口愈合等级20
     */
    private String c42x20c;

    /**
     * 其他手术操作麻醉方式20
     */
    private String c43x20c;

    /**
     * 其他手术操作麻醉医师20
     */
    private String c44x20;

    /**
     * 其他手术操作编码21
     */
    private String c35x21c;

    /**
     * 其他手术操作名称21
     */
    private String c36x21n;

    /**
     * 其他手术操作日期21
     */
    private Date c37x21;

    /**
     * 其他手术操作级别21
     */
    private String c38x21;

    /**
     * 其他手术操作术者21
     */
    private String c39x21;

    /**
     * 其他手术操作Ⅰ助21
     */
    private String c40x21;

    /**
     * 其他手术操作Ⅱ助21
     */
    private String c41x21;

    /**
     * 其他手术操作切口愈合等级21
     */
    private String c42x21c;

    /**
     * 其他手术操作麻醉方式21
     */
    private String c43x21c;

    /**
     * 其他手术操作麻醉医师21
     */
    private String c44x21;

    /**
     * 其他手术操作编码22
     */
    private String c35x22c;

    /**
     * 其他手术操作名称22
     */
    private String c36x22n;

    /**
     * 其他手术操作日期22
     */
    private Date c37x22;

    /**
     * 其他手术操作级别22
     */
    private String c38x22;

    /**
     * 其他手术操作术者22
     */
    private String c39x22;

    /**
     * 其他手术操作Ⅰ助22
     */
    private String c40x22;

    /**
     * 其他手术操作Ⅱ助22
     */
    private String c41x22;

    /**
     * 其他手术操作切口愈合等级22
     */
    private String c42x22c;

    /**
     * 其他手术操作麻醉方式22
     */
    private String c43x22c;

    /**
     * 其他手术操作麻醉医师22
     */
    private String c44x22;

    /**
     * 其他手术操作编码23
     */
    private String c35x23c;

    /**
     * 其他手术操作名称23
     */
    private String c36x23n;

    /**
     * 其他手术操作日期23
     */
    private Date c37x23;

    /**
     * 其他手术操作级别23
     */
    private String c38x23;

    /**
     * 其他手术操作术者23
     */
    private String c39x23;

    /**
     * 其他手术操作Ⅰ助23
     */
    private String c40x23;

    /**
     * 其他手术操作Ⅱ助23
     */
    private String c41x23;

    /**
     * 其他手术操作切口愈合等级23
     */
    private String c42x23c;

    /**
     * 其他手术操作麻醉方式23
     */
    private String c43x23c;

    /**
     * 其他手术操作麻醉医师23
     */
    private String c44x23;

    /**
     * 其他手术操作编码24
     */
    private String c35x24c;

    /**
     * 其他手术操作名称24
     */
    private String c36x24n;

    /**
     * 其他手术操作日期24
     */
    private Date c37x24;

    /**
     * 其他手术操作级别24
     */
    private String c38x24;

    /**
     * 其他手术操作术者24
     */
    private String c39x24;

    /**
     * 其他手术操作Ⅰ助24
     */
    private String c40x24;

    /**
     * 其他手术操作Ⅱ助24
     */
    private String c41x24;

    /**
     * 其他手术操作切口愈合等级24
     */
    private String c42x24c;

    /**
     * 其他手术操作麻醉方式24
     */
    private String c43x24c;

    /**
     * 其他手术操作麻醉医师24
     */
    private String c44x24;

    /**
     * 其他手术操作编码25
     */
    private String c35x25c;

    /**
     * 其他手术操作名称25
     */
    private String c36x25n;

    /**
     * 其他手术操作日期25
     */
    private Date c37x25;

    /**
     * 其他手术操作级别25
     */
    private String c38x25;

    /**
     * 其他手术操作术者25
     */
    private String c39x25;

    /**
     * 其他手术操作Ⅰ助25
     */
    private String c40x25;

    /**
     * 其他手术操作Ⅱ助25
     */
    private String c41x25;

    /**
     * 其他手术操作切口愈合等级25
     */
    private String c42x25c;

    /**
     * 其他手术操作麻醉方式25
     */
    private String c43x25c;

    /**
     * 其他手术操作麻醉医师25
     */
    private String c44x25;

    /**
     * 其他手术操作编码26
     */
    private String c35x26c;

    /**
     * 其他手术操作名称26
     */
    private String c36x26n;

    /**
     * 其他手术操作日期26
     */
    private Date c37x26;

    /**
     * 其他手术操作级别26
     */
    private String c38x26;

    /**
     * 其他手术操作术者26
     */
    private String c39x26;

    /**
     * 其他手术操作Ⅰ助26
     */
    private String c40x26;

    /**
     * 其他手术操作Ⅱ助26
     */
    private String c41x26;

    /**
     * 其他手术操作切口愈合等级26
     */
    private String c42x26c;

    /**
     * 其他手术操作麻醉方式26
     */
    private String c43x26c;

    /**
     * 其他手术操作麻醉医师26
     */
    private String c44x26;

    /**
     * 其他手术操作编码27
     */
    private String c35x27c;

    /**
     * 其他手术操作名称27
     */
    private String c36x27n;

    /**
     * 其他手术操作日期27
     */
    private Date c37x27;

    /**
     * 其他手术操作级别27
     */
    private String c38x27;

    /**
     * 其他手术操作术者27
     */
    private String c39x27;

    /**
     * 其他手术操作Ⅰ助27
     */
    private String c40x27;

    /**
     * 其他手术操作Ⅱ助27
     */
    private String c41x27;

    /**
     * 其他手术操作切口愈合等级27
     */
    private String c42x27c;

    /**
     * 其他手术操作麻醉方式27
     */
    private String c43x27c;

    /**
     * 其他手术操作麻醉医师27
     */
    private String c44x27;

    /**
     * 其他手术操作编码28
     */
    private String c35x28c;

    /**
     * 其他手术操作名称28
     */
    private String c36x28n;

    /**
     * 其他手术操作日期28
     */
    private Date c37x28;

    /**
     * 其他手术操作级别28
     */
    private String c38x28;

    /**
     * 其他手术操作术者28
     */
    private String c39x28;

    /**
     * 其他手术操作Ⅰ助28
     */
    private String c40x28;

    /**
     * 其他手术操作Ⅱ助28
     */
    private String c41x28;

    /**
     * 其他手术操作切口愈合等级28
     */
    private String c42x28c;

    /**
     * 其他手术操作麻醉方式28
     */
    private String c43x28c;

    /**
     * 其他手术操作麻醉医师28
     */
    private String c44x28;

    /**
     * 其他手术操作编码29
     */
    private String c35x29c;

    /**
     * 其他手术操作名称29
     */
    private String c36x29n;

    /**
     * 其他手术操作日期29
     */
    private Date c37x29;

    /**
     * 其他手术操作级别29
     */
    private String c38x29;

    /**
     * 其他手术操作术者29
     */
    private String c39x29;

    /**
     * 其他手术操作Ⅰ助29
     */
    private String c40x29;

    /**
     * 其他手术操作Ⅱ助29
     */
    private String c41x29;

    /**
     * 其他手术操作切口愈合等级29
     */
    private String c42x29c;

    /**
     * 其他手术操作麻醉方式29
     */
    private String c43x29c;

    /**
     * 其他手术操作麻醉医师29
     */
    private String c44x29;

    /**
     * 其他手术操作编码30
     */
    private String c35x30c;

    /**
     * 其他手术操作名称30
     */
    private String c36x30n;

    /**
     * 其他手术操作日期30
     */
    private Date c37x30;

    /**
     * 其他手术操作级别30
     */
    private String c38x30;

    /**
     * 其他手术操作术者30
     */
    private String c39x30;

    /**
     * 其他手术操作Ⅰ助30
     */
    private String c40x30;

    /**
     * 其他手术操作Ⅱ助30
     */
    private String c41x30;

    /**
     * 其他手术操作切口愈合等级30
     */
    private String c42x30c;

    /**
     * 其他手术操作麻醉方式30
     */
    private String c43x30c;

    /**
     * 其他手术操作麻醉医师30
     */
    private String c44x30;

    /**
     * 其他手术操作编码31
     */
    private String c35x31c;

    /**
     * 其他手术操作名称31
     */
    private String c36x31n;

    /**
     * 其他手术操作日期31
     */
    private Date c37x31;

    /**
     * 其他手术操作级别31
     */
    private String c38x31;

    /**
     * 其他手术操作术者31
     */
    private String c39x31;

    /**
     * 其他手术操作Ⅰ助31
     */
    private String c40x31;

    /**
     * 其他手术操作Ⅱ助31
     */
    private String c41x31;

    /**
     * 其他手术操作切口愈合等级31
     */
    private String c42x31c;

    /**
     * 其他手术操作麻醉方式31
     */
    private String c43x31c;

    /**
     * 其他手术操作麻醉医师31
     */
    private String c44x31;

    /**
     * 其他手术操作编码32
     */
    private String c35x32c;

    /**
     * 其他手术操作名称32
     */
    private String c36x32n;

    /**
     * 其他手术操作日期32
     */
    private Date c37x32;

    /**
     * 其他手术操作级别32
     */
    private String c38x32;

    /**
     * 其他手术操作术者32
     */
    private String c39x32;

    /**
     * 其他手术操作Ⅰ助32
     */
    private String c40x32;

    /**
     * 其他手术操作Ⅱ助32
     */
    private String c41x32;

    /**
     * 其他手术操作切口愈合等级32
     */
    private String c42x32c;

    /**
     * 其他手术操作麻醉方式32
     */
    private String c43x32c;

    /**
     * 其他手术操作麻醉医师32
     */
    private String c44x32;

    /**
     * 其他手术操作编码33
     */
    private String c35x33c;

    /**
     * 其他手术操作名称33
     */
    private String c36x33n;

    /**
     * 其他手术操作日期33
     */
    private Date c37x33;

    /**
     * 其他手术操作级别33
     */
    private String c38x33;

    /**
     * 其他手术操作术者33
     */
    private String c39x33;

    /**
     * 其他手术操作Ⅰ助33
     */
    private String c40x33;

    /**
     * 其他手术操作Ⅱ助33
     */
    private String c41x33;

    /**
     * 其他手术操作切口愈合等级33
     */
    private String c42x33c;

    /**
     * 其他手术操作麻醉方式33
     */
    private String c43x33c;

    /**
     * 其他手术操作麻醉医师33
     */
    private String c44x33;

    /**
     * 其他手术操作编码34
     */
    private String c35x34c;

    /**
     * 其他手术操作名称34
     */
    private String c36x34n;

    /**
     * 其他手术操作日期34
     */
    private Date c37x34;

    /**
     * 其他手术操作级别34
     */
    private String c38x34;

    /**
     * 其他手术操作术者34
     */
    private String c39x34;

    /**
     * 其他手术操作Ⅰ助34
     */
    private String c40x34;

    /**
     * 其他手术操作Ⅱ助34
     */
    private String c41x34;

    /**
     * 其他手术操作切口愈合等级34
     */
    private String c42x34c;

    /**
     * 其他手术操作麻醉方式34
     */
    private String c43x34c;

    /**
     * 其他手术操作麻醉医师34
     */
    private String c44x34;

    /**
     * 其他手术操作编码35
     */
    private String c35x35c;

    /**
     * 其他手术操作名称35
     */
    private String c36x35n;

    /**
     * 其他手术操作日期35
     */
    private Date c37x35;

    /**
     * 其他手术操作级别35
     */
    private String c38x35;

    /**
     * 其他手术操作术者35
     */
    private String c39x35;

    /**
     * 其他手术操作Ⅰ助35
     */
    private String c40x35;

    /**
     * 其他手术操作Ⅱ助35
     */
    private String c41x35;

    /**
     * 其他手术操作切口愈合等级35
     */
    private String c42x35c;

    /**
     * 其他手术操作麻醉方式35
     */
    private String c43x35c;

    /**
     * 其他手术操作麻醉医师35
     */
    private String c44x35;

    /**
     * 其他手术操作编码36
     */
    private String c35x36c;

    /**
     * 其他手术操作名称36
     */
    private String c36x36n;

    /**
     * 其他手术操作日期36
     */
    private Date c37x36;

    /**
     * 其他手术操作级别36
     */
    private String c38x36;

    /**
     * 其他手术操作术者36
     */
    private String c39x36;

    /**
     * 其他手术操作Ⅰ助36
     */
    private String c40x36;

    /**
     * 其他手术操作Ⅱ助36
     */
    private String c41x36;

    /**
     * 其他手术操作切口愈合等级36
     */
    private String c42x36c;

    /**
     * 其他手术操作麻醉方式36
     */
    private String c43x36c;

    /**
     * 其他手术操作麻醉医师36
     */
    private String c44x36;

    /**
     * 其他手术操作编码37
     */
    private String c35x37c;

    /**
     * 其他手术操作名称37
     */
    private String c36x37n;

    /**
     * 其他手术操作日期37
     */
    private Date c37x37;

    /**
     * 其他手术操作级别37
     */
    private String c38x37;

    /**
     * 其他手术操作术者37
     */
    private String c39x37;

    /**
     * 其他手术操作Ⅰ助37
     */
    private String c40x37;

    /**
     * 其他手术操作Ⅱ助37
     */
    private String c41x37;

    /**
     * 其他手术操作切口愈合等级37
     */
    private String c42x37c;

    /**
     * 其他手术操作麻醉方式37
     */
    private String c43x37c;

    /**
     * 其他手术操作麻醉医师37
     */
    private String c44x37;

    /**
     * 其他手术操作编码38
     */
    private String c35x38c;

    /**
     * 其他手术操作名称38
     */
    private String c36x38n;

    /**
     * 其他手术操作日期38
     */
    private Date c37x38;

    /**
     * 其他手术操作级别38
     */
    private String c38x38;

    /**
     * 其他手术操作术者38
     */
    private String c39x38;

    /**
     * 其他手术操作Ⅰ助38
     */
    private String c40x38;

    /**
     * 其他手术操作Ⅱ助38
     */
    private String c41x38;

    /**
     * 其他手术操作切口愈合等级38
     */
    private String c42x38c;

    /**
     * 其他手术操作麻醉方式38
     */
    private String c43x38c;

    /**
     * 其他手术操作麻醉医师38
     */
    private String c44x38;

    /**
     * 其他手术操作编码39
     */
    private String c35x39c;

    /**
     * 其他手术操作名称39
     */
    private String c36x39n;

    /**
     * 其他手术操作日期39
     */
    private Date c37x39;

    /**
     * 其他手术操作级别39
     */
    private String c38x39;

    /**
     * 其他手术操作术者39
     */
    private String c39x39;

    /**
     * 其他手术操作Ⅰ助39
     */
    private String c40x39;

    /**
     * 其他手术操作Ⅱ助39
     */
    private String c41x39;

    /**
     * 其他手术操作切口愈合等级39
     */
    private String c42x39c;

    /**
     * 其他手术操作麻醉方式39
     */
    private String c43x39c;

    /**
     * 其他手术操作麻醉医师39
     */
    private String c44x39;

    /**
     * 其他手术操作编码40
     */
    private String c35x40c;

    /**
     * 其他手术操作名称40
     */
    private String c36x40n;

    /**
     * 其他手术操作日期40
     */
    private Date c37x40;

    /**
     * 其他手术操作级别40
     */
    private String c38x40;

    /**
     * 其他手术操作术者40
     */
    private String c39x40;

    /**
     * 其他手术操作Ⅰ助40
     */
    private String c40x40;

    /**
     * 其他手术操作Ⅱ助40
     */
    private String c41x40;

    /**
     * 其他手术操作切口愈合等级40
     */
    private String c42x40c;

    /**
     * 其他手术操作麻醉方式40
     */
    private String c43x40c;

    /**
     * 其他手术操作麻醉医师40
     */
    private String c44x40;

    /**
     * 住院总费用
     */
    @NotNull(message = "住院总费用不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d01;

    /**
     * 住院总费用其中自付金额
     */
    @NotNull(message = "住院总费用其中自付金额不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d09;

    /**
     * 1.一般医疗服务费
     */
    @NotNull(message = "1.一般医疗服务费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d11;

    /**
     * 2.一般治疗操作费
     */
    @NotNull(message = "2.一般治疗操作费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d12;

    /**
     * 3.护理费
     */
    @NotNull(message = "3.护理费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d13;

    /**
     * 4.综合医疗服务类其他费用
     */
    @NotNull(message = "4.综合医疗服务类其他费用不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d14;

    /**
     * 5.病理诊断费
     */
    @NotNull(message = "5.病理诊断费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d15;

    /**
     * 6.实验室诊断费
     */
    @NotNull(message = "6.实验室诊断费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d16;

    /**
     * 7.影像学诊断费
     */
    @NotNull(message = "7.影像学诊断费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d17;

    /**
     * 8.临床诊断项目费
     */
    @NotNull(message = "8.临床诊断项目费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d18;

    /**
     * 9.非手术治疗项目费
     */
    @NotNull(message = "9.非手术治疗项目费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d19;

    /**
     * 其中:临床物理治疗费
     */
    @NotNull(message = "其中:临床物理治疗费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d19x01;

    /**
     * 10.手术治疗费
     */
    @NotNull(message = "10.手术治疗费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d20;

    /**
     * 其中:麻醉费
     */
    @NotNull(message = "其中:麻醉费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d20x01;

    /**
     * 其中:手术费
     */
    @NotNull(message = "其中:手术费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d20x02;

    /**
     * 11.康复费
     */
    @NotNull(message = "11.康复费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d21;

    /**
     * 12.中医治疗费
     */
    @NotNull(message = "12.中医治疗费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d22;

    /**
     * 13.西药费
     */
    @NotNull(message = "13.西药费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d23;

    /**
     * 其中:抗菌药物费
     */
    @NotNull(message = "其中:抗菌药物费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d23x01;

    /**
     * 14.中成药费
     */
    @NotNull(message = "14.中成药费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d24;

    /**
     * 15.中草药费
     */
    @NotNull(message = "15.中草药费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d25;

    /**
     * 16.血费
     */
    @NotNull(message = "16.血费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d26;

    /**
     * 17.白蛋白类制品费
     */
    @NotNull(message = "17.白蛋白类制品费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d27;

    /**
     * 18.球蛋白类制品费
     */
    @NotNull(message = "18.球蛋白类制品费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d28;

    /**
     * 19.凝血因子类制品费
     */
    @NotNull(message = "19.凝血因子类制品费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d29;

    /**
     * 20.细胞因子类制品费
     */
    @NotNull(message = "20.细胞因子类制品费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d30;

    /**
     * 21.检查用一次性医用材料费
     */
    @NotNull(message = "21.检查用一次性医用材料费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d31;

    /**
     * 22.治疗用一次性医用材料费
     */
    @NotNull(message = "22.治疗用一次性医用材料费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d32;

    /**
     * 23.手术用一次性医用材料费
     */
    @NotNull(message = "23.手术用一次性医用材料费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d33;

    /**
     * 24.其他费
     */
    @NotNull(message = "24.其他费不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long d34;

    /**
     * 扩展字段1-预留
     */
    private String e01;

    /**
     * 扩展字段2-预留
     */
    private String e02;

    /**
     * 扩展字段3-预留
     */
    private String e03;

    /**
     * 扩展字段4-预留
     */
    private String e04;

    /**
     * 扩展字段5-预留时间
     */
    private Date e05;

    /**
     * 扩展字段6-预留金额
     */
    private Long e06;

    /**
     * 扩展字段7-预留数字
     */
    private Long e07;

    /**
     * 扩展字段8-预留文本
     */
    private String e08;

    /**
     * 扩展字段9-预留布尔值
     */
    private Long e09;

    /**
     * 扩展字段10-预留编码
     */
    private String e10;


}
