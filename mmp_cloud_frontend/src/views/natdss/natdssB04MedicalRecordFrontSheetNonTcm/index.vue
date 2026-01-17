<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="组织机构代码" prop="a01">
              <el-input v-model="queryParams.a01" placeholder="请输入组织机构代码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医疗机构名称" prop="a02">
              <el-input v-model="queryParams.a02" placeholder="请输入医疗机构名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="病案号" prop="a48">
              <el-input v-model="queryParams.a48" placeholder="请输入病案号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="住院次数" prop="a49">
              <el-input v-model="queryParams.a49" placeholder="请输入住院次数" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="入院时间" prop="b12">
              <el-date-picker clearable
                v-model="queryParams.b12"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择入院时间"
              />
            </el-form-item>
            <el-form-item label="出院时间" prop="b15">
              <el-date-picker clearable
                v-model="queryParams.b15"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择出院时间"
              />
            </el-form-item>
            <el-form-item label="健康卡号" prop="a47">
              <el-input v-model="queryParams.a47" placeholder="请输入健康卡号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医疗付费方式" prop="a46c">
              <el-input v-model="queryParams.a46c" placeholder="请输入医疗付费方式" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="姓名" prop="a11">
              <el-input v-model="queryParams.a11" placeholder="请输入姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="性别" prop="a12c">
              <el-input v-model="queryParams.a12c" placeholder="请输入性别" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出生日期" prop="a13">
              <el-date-picker clearable
                v-model="queryParams.a13"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择出生日期"
              />
            </el-form-item>
            <el-form-item label="年龄(岁)" prop="a14">
              <el-input v-model="queryParams.a14" placeholder="请输入年龄(岁)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="国籍" prop="a15c">
              <el-input v-model="queryParams.a15c" placeholder="请输入国籍" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="婚姻" prop="a21c">
              <el-input v-model="queryParams.a21c" placeholder="请输入婚姻" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="职业" prop="a38c">
              <el-input v-model="queryParams.a38c" placeholder="请输入职业" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="民族" prop="a19c">
              <el-input v-model="queryParams.a19c" placeholder="请输入民族" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="身份证号" prop="a20">
              <el-input v-model="queryParams.a20" placeholder="请输入身份证号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出生地址" prop="a22">
              <el-input v-model="queryParams.a22" placeholder="请输入出生地址" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="籍贯省(自治区、直辖市)" prop="a23c">
              <el-input v-model="queryParams.a23c" placeholder="请输入籍贯省(自治区、直辖市)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="户口地址" prop="a24">
              <el-input v-model="queryParams.a24" placeholder="请输入户口地址" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="户口地址邮政编码" prop="a25c">
              <el-input v-model="queryParams.a25c" placeholder="请输入户口地址邮政编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="现住址" prop="a26">
              <el-input v-model="queryParams.a26" placeholder="请输入现住址" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="现住址电话" prop="a27">
              <el-input v-model="queryParams.a27" placeholder="请输入现住址电话" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="现住址邮政编码" prop="a28c">
              <el-input v-model="queryParams.a28c" placeholder="请输入现住址邮政编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="工作单位及地址" prop="a29">
              <el-input v-model="queryParams.a29" placeholder="请输入工作单位及地址" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="工作单位电话" prop="a30">
              <el-input v-model="queryParams.a30" placeholder="请输入工作单位电话" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="工作单位邮政编码" prop="a31c">
              <el-input v-model="queryParams.a31c" placeholder="请输入工作单位邮政编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="联系人姓名" prop="a32">
              <el-input v-model="queryParams.a32" placeholder="请输入联系人姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="联系人关系" prop="a33c">
              <el-input v-model="queryParams.a33c" placeholder="请输入联系人关系" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="联系人地址" prop="a34">
              <el-input v-model="queryParams.a34" placeholder="请输入联系人地址" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="联系人电话" prop="a35">
              <el-input v-model="queryParams.a35" placeholder="请输入联系人电话" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="入院途径" prop="b11c">
              <el-input v-model="queryParams.b11c" placeholder="请输入入院途径" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="入院科别" prop="b13c">
              <el-input v-model="queryParams.b13c" placeholder="请输入入院科别" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="入院病房" prop="b14">
              <el-input v-model="queryParams.b14" placeholder="请输入入院病房" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="转科科别" prop="b21c">
              <el-input v-model="queryParams.b21c" placeholder="请输入转科科别" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院科别" prop="b16c">
              <el-input v-model="queryParams.b16c" placeholder="请输入出院科别" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院病房" prop="b17">
              <el-input v-model="queryParams.b17" placeholder="请输入出院病房" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="实际住院(天)" prop="b20">
              <el-input v-model="queryParams.b20" placeholder="请输入实际住院(天)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="门(急)诊诊断编码" prop="c01c">
              <el-input v-model="queryParams.c01c" placeholder="请输入门(急)诊诊断编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="门(急)诊诊断名称" prop="c02n">
              <el-input v-model="queryParams.c02n" placeholder="请输入门(急)诊诊断名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院主要诊断编码" prop="c03c">
              <el-input v-model="queryParams.c03c" placeholder="请输入出院主要诊断编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院主要诊断名称" prop="c04n">
              <el-input v-model="queryParams.c04n" placeholder="请输入出院主要诊断名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院主要诊断入院病情" prop="c05c">
              <el-input v-model="queryParams.c05c" placeholder="请输入出院主要诊断入院病情" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码1" prop="c06x01c">
              <el-input v-model="queryParams.c06x01c" placeholder="请输入出院其他诊断编码1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称1" prop="c07x01n">
              <el-input v-model="queryParams.c07x01n" placeholder="请输入出院其他诊断名称1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情1" prop="c08x01c">
              <el-input v-model="queryParams.c08x01c" placeholder="请输入出院其他诊断入院病情1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码2" prop="c06x02c">
              <el-input v-model="queryParams.c06x02c" placeholder="请输入出院其他诊断编码2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称2" prop="c07x02n">
              <el-input v-model="queryParams.c07x02n" placeholder="请输入出院其他诊断名称2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情2" prop="c08x02c">
              <el-input v-model="queryParams.c08x02c" placeholder="请输入出院其他诊断入院病情2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码3" prop="c06x03c">
              <el-input v-model="queryParams.c06x03c" placeholder="请输入出院其他诊断编码3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称3" prop="c07x03n">
              <el-input v-model="queryParams.c07x03n" placeholder="请输入出院其他诊断名称3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情3" prop="c08x03c">
              <el-input v-model="queryParams.c08x03c" placeholder="请输入出院其他诊断入院病情3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码4" prop="c06x04c">
              <el-input v-model="queryParams.c06x04c" placeholder="请输入出院其他诊断编码4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称4" prop="c07x04n">
              <el-input v-model="queryParams.c07x04n" placeholder="请输入出院其他诊断名称4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情4" prop="c08x04c">
              <el-input v-model="queryParams.c08x04c" placeholder="请输入出院其他诊断入院病情4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码5" prop="c06x05c">
              <el-input v-model="queryParams.c06x05c" placeholder="请输入出院其他诊断编码5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称5" prop="c07x05n">
              <el-input v-model="queryParams.c07x05n" placeholder="请输入出院其他诊断名称5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情5" prop="c08x05c">
              <el-input v-model="queryParams.c08x05c" placeholder="请输入出院其他诊断入院病情5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码6" prop="c06x06c">
              <el-input v-model="queryParams.c06x06c" placeholder="请输入出院其他诊断编码6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称6" prop="c07x06n">
              <el-input v-model="queryParams.c07x06n" placeholder="请输入出院其他诊断名称6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情6" prop="c08x06c">
              <el-input v-model="queryParams.c08x06c" placeholder="请输入出院其他诊断入院病情6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码7" prop="c06x07c">
              <el-input v-model="queryParams.c06x07c" placeholder="请输入出院其他诊断编码7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称7" prop="c07x07n">
              <el-input v-model="queryParams.c07x07n" placeholder="请输入出院其他诊断名称7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情7" prop="c08x07c">
              <el-input v-model="queryParams.c08x07c" placeholder="请输入出院其他诊断入院病情7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码8" prop="c06x08c">
              <el-input v-model="queryParams.c06x08c" placeholder="请输入出院其他诊断编码8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称8" prop="c07x08n">
              <el-input v-model="queryParams.c07x08n" placeholder="请输入出院其他诊断名称8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情8" prop="c08x08c">
              <el-input v-model="queryParams.c08x08c" placeholder="请输入出院其他诊断入院病情8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码9" prop="c06x09c">
              <el-input v-model="queryParams.c06x09c" placeholder="请输入出院其他诊断编码9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称9" prop="c07x09n">
              <el-input v-model="queryParams.c07x09n" placeholder="请输入出院其他诊断名称9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情9" prop="c08x09c">
              <el-input v-model="queryParams.c08x09c" placeholder="请输入出院其他诊断入院病情9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码10" prop="c06x10c">
              <el-input v-model="queryParams.c06x10c" placeholder="请输入出院其他诊断编码10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称10" prop="c07x10n">
              <el-input v-model="queryParams.c07x10n" placeholder="请输入出院其他诊断名称10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情10" prop="c08x10c">
              <el-input v-model="queryParams.c08x10c" placeholder="请输入出院其他诊断入院病情10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码11" prop="c06x11c">
              <el-input v-model="queryParams.c06x11c" placeholder="请输入出院其他诊断编码11" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称11" prop="c07x11n">
              <el-input v-model="queryParams.c07x11n" placeholder="请输入出院其他诊断名称11" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情11" prop="c08x11c">
              <el-input v-model="queryParams.c08x11c" placeholder="请输入出院其他诊断入院病情11" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码12" prop="c06x12c">
              <el-input v-model="queryParams.c06x12c" placeholder="请输入出院其他诊断编码12" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称12" prop="c07x12n">
              <el-input v-model="queryParams.c07x12n" placeholder="请输入出院其他诊断名称12" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情12" prop="c08x12c">
              <el-input v-model="queryParams.c08x12c" placeholder="请输入出院其他诊断入院病情12" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码13" prop="c06x13c">
              <el-input v-model="queryParams.c06x13c" placeholder="请输入出院其他诊断编码13" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称13" prop="c07x13n">
              <el-input v-model="queryParams.c07x13n" placeholder="请输入出院其他诊断名称13" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情13" prop="c08x13c">
              <el-input v-model="queryParams.c08x13c" placeholder="请输入出院其他诊断入院病情13" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码14" prop="c06x14c">
              <el-input v-model="queryParams.c06x14c" placeholder="请输入出院其他诊断编码14" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称14" prop="c07x14n">
              <el-input v-model="queryParams.c07x14n" placeholder="请输入出院其他诊断名称14" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情14" prop="c08x14c">
              <el-input v-model="queryParams.c08x14c" placeholder="请输入出院其他诊断入院病情14" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码15" prop="c06x15c">
              <el-input v-model="queryParams.c06x15c" placeholder="请输入出院其他诊断编码15" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称15" prop="c07x15n">
              <el-input v-model="queryParams.c07x15n" placeholder="请输入出院其他诊断名称15" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情15" prop="c08x15c">
              <el-input v-model="queryParams.c08x15c" placeholder="请输入出院其他诊断入院病情15" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码16" prop="c06x16c">
              <el-input v-model="queryParams.c06x16c" placeholder="请输入出院其他诊断编码16" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称16" prop="c07x16n">
              <el-input v-model="queryParams.c07x16n" placeholder="请输入出院其他诊断名称16" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情16" prop="c08x16c">
              <el-input v-model="queryParams.c08x16c" placeholder="请输入出院其他诊断入院病情16" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码17" prop="c06x17c">
              <el-input v-model="queryParams.c06x17c" placeholder="请输入出院其他诊断编码17" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称17" prop="c07x17n">
              <el-input v-model="queryParams.c07x17n" placeholder="请输入出院其他诊断名称17" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情17" prop="c08x17c">
              <el-input v-model="queryParams.c08x17c" placeholder="请输入出院其他诊断入院病情17" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码18" prop="c06x18c">
              <el-input v-model="queryParams.c06x18c" placeholder="请输入出院其他诊断编码18" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称18" prop="c07x18n">
              <el-input v-model="queryParams.c07x18n" placeholder="请输入出院其他诊断名称18" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情18" prop="c08x18c">
              <el-input v-model="queryParams.c08x18c" placeholder="请输入出院其他诊断入院病情18" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码19" prop="c06x19c">
              <el-input v-model="queryParams.c06x19c" placeholder="请输入出院其他诊断编码19" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称19" prop="c07x19n">
              <el-input v-model="queryParams.c07x19n" placeholder="请输入出院其他诊断名称19" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情19" prop="c08x19c">
              <el-input v-model="queryParams.c08x19c" placeholder="请输入出院其他诊断入院病情19" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码20" prop="c06x20c">
              <el-input v-model="queryParams.c06x20c" placeholder="请输入出院其他诊断编码20" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称20" prop="c07x20n">
              <el-input v-model="queryParams.c07x20n" placeholder="请输入出院其他诊断名称20" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情20" prop="c08x20c">
              <el-input v-model="queryParams.c08x20c" placeholder="请输入出院其他诊断入院病情20" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码21" prop="c06x21c">
              <el-input v-model="queryParams.c06x21c" placeholder="请输入出院其他诊断编码21" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称21" prop="c07x21n">
              <el-input v-model="queryParams.c07x21n" placeholder="请输入出院其他诊断名称21" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情21" prop="c08x21c">
              <el-input v-model="queryParams.c08x21c" placeholder="请输入出院其他诊断入院病情21" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码22" prop="c06x22c">
              <el-input v-model="queryParams.c06x22c" placeholder="请输入出院其他诊断编码22" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称22" prop="c07x22n">
              <el-input v-model="queryParams.c07x22n" placeholder="请输入出院其他诊断名称22" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情22" prop="c08x22c">
              <el-input v-model="queryParams.c08x22c" placeholder="请输入出院其他诊断入院病情22" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码23" prop="c06x23c">
              <el-input v-model="queryParams.c06x23c" placeholder="请输入出院其他诊断编码23" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称23" prop="c07x23n">
              <el-input v-model="queryParams.c07x23n" placeholder="请输入出院其他诊断名称23" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情23" prop="c08x23c">
              <el-input v-model="queryParams.c08x23c" placeholder="请输入出院其他诊断入院病情23" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码24" prop="c06x24c">
              <el-input v-model="queryParams.c06x24c" placeholder="请输入出院其他诊断编码24" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称24" prop="c07x24n">
              <el-input v-model="queryParams.c07x24n" placeholder="请输入出院其他诊断名称24" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情24" prop="c08x24c">
              <el-input v-model="queryParams.c08x24c" placeholder="请输入出院其他诊断入院病情24" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码25" prop="c06x25c">
              <el-input v-model="queryParams.c06x25c" placeholder="请输入出院其他诊断编码25" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称25" prop="c07x25n">
              <el-input v-model="queryParams.c07x25n" placeholder="请输入出院其他诊断名称25" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情25" prop="c08x25c">
              <el-input v-model="queryParams.c08x25c" placeholder="请输入出院其他诊断入院病情25" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码26" prop="c06x26c">
              <el-input v-model="queryParams.c06x26c" placeholder="请输入出院其他诊断编码26" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称26" prop="c07x26n">
              <el-input v-model="queryParams.c07x26n" placeholder="请输入出院其他诊断名称26" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情26" prop="c08x26c">
              <el-input v-model="queryParams.c08x26c" placeholder="请输入出院其他诊断入院病情26" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码27" prop="c06x27c">
              <el-input v-model="queryParams.c06x27c" placeholder="请输入出院其他诊断编码27" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称27" prop="c07x27n">
              <el-input v-model="queryParams.c07x27n" placeholder="请输入出院其他诊断名称27" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情27" prop="c08x27c">
              <el-input v-model="queryParams.c08x27c" placeholder="请输入出院其他诊断入院病情27" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码28" prop="c06x28c">
              <el-input v-model="queryParams.c06x28c" placeholder="请输入出院其他诊断编码28" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称28" prop="c07x28n">
              <el-input v-model="queryParams.c07x28n" placeholder="请输入出院其他诊断名称28" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情28" prop="c08x28c">
              <el-input v-model="queryParams.c08x28c" placeholder="请输入出院其他诊断入院病情28" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码29" prop="c06x29c">
              <el-input v-model="queryParams.c06x29c" placeholder="请输入出院其他诊断编码29" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称29" prop="c07x29n">
              <el-input v-model="queryParams.c07x29n" placeholder="请输入出院其他诊断名称29" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情29" prop="c08x29c">
              <el-input v-model="queryParams.c08x29c" placeholder="请输入出院其他诊断入院病情29" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码30" prop="c06x30c">
              <el-input v-model="queryParams.c06x30c" placeholder="请输入出院其他诊断编码30" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称30" prop="c07x30n">
              <el-input v-model="queryParams.c07x30n" placeholder="请输入出院其他诊断名称30" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情30" prop="c08x30c">
              <el-input v-model="queryParams.c08x30c" placeholder="请输入出院其他诊断入院病情30" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码31" prop="c06x31c">
              <el-input v-model="queryParams.c06x31c" placeholder="请输入出院其他诊断编码31" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称31" prop="c07x31n">
              <el-input v-model="queryParams.c07x31n" placeholder="请输入出院其他诊断名称31" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情31" prop="c08x31c">
              <el-input v-model="queryParams.c08x31c" placeholder="请输入出院其他诊断入院病情31" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码32" prop="c06x32c">
              <el-input v-model="queryParams.c06x32c" placeholder="请输入出院其他诊断编码32" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称32" prop="c07x32n">
              <el-input v-model="queryParams.c07x32n" placeholder="请输入出院其他诊断名称32" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情32" prop="c08x32c">
              <el-input v-model="queryParams.c08x32c" placeholder="请输入出院其他诊断入院病情32" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码33" prop="c06x33c">
              <el-input v-model="queryParams.c06x33c" placeholder="请输入出院其他诊断编码33" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称33" prop="c07x33n">
              <el-input v-model="queryParams.c07x33n" placeholder="请输入出院其他诊断名称33" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情33" prop="c08x33c">
              <el-input v-model="queryParams.c08x33c" placeholder="请输入出院其他诊断入院病情33" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码34" prop="c06x34c">
              <el-input v-model="queryParams.c06x34c" placeholder="请输入出院其他诊断编码34" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称34" prop="c07x34n">
              <el-input v-model="queryParams.c07x34n" placeholder="请输入出院其他诊断名称34" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情34" prop="c08x34c">
              <el-input v-model="queryParams.c08x34c" placeholder="请输入出院其他诊断入院病情34" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码35" prop="c06x35c">
              <el-input v-model="queryParams.c06x35c" placeholder="请输入出院其他诊断编码35" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称35" prop="c07x35n">
              <el-input v-model="queryParams.c07x35n" placeholder="请输入出院其他诊断名称35" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情35" prop="c08x35c">
              <el-input v-model="queryParams.c08x35c" placeholder="请输入出院其他诊断入院病情35" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码36" prop="c06x36c">
              <el-input v-model="queryParams.c06x36c" placeholder="请输入出院其他诊断编码36" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称36" prop="c07x36n">
              <el-input v-model="queryParams.c07x36n" placeholder="请输入出院其他诊断名称36" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情36" prop="c08x36c">
              <el-input v-model="queryParams.c08x36c" placeholder="请输入出院其他诊断入院病情36" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码37" prop="c06x37c">
              <el-input v-model="queryParams.c06x37c" placeholder="请输入出院其他诊断编码37" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称37" prop="c07x37n">
              <el-input v-model="queryParams.c07x37n" placeholder="请输入出院其他诊断名称37" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情37" prop="c08x37c">
              <el-input v-model="queryParams.c08x37c" placeholder="请输入出院其他诊断入院病情37" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码38" prop="c06x38c">
              <el-input v-model="queryParams.c06x38c" placeholder="请输入出院其他诊断编码38" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称38" prop="c07x38n">
              <el-input v-model="queryParams.c07x38n" placeholder="请输入出院其他诊断名称38" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情38" prop="c08x38c">
              <el-input v-model="queryParams.c08x38c" placeholder="请输入出院其他诊断入院病情38" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码39" prop="c06x39c">
              <el-input v-model="queryParams.c06x39c" placeholder="请输入出院其他诊断编码39" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称39" prop="c07x39n">
              <el-input v-model="queryParams.c07x39n" placeholder="请输入出院其他诊断名称39" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情39" prop="c08x39c">
              <el-input v-model="queryParams.c08x39c" placeholder="请输入出院其他诊断入院病情39" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断编码40" prop="c06x40c">
              <el-input v-model="queryParams.c06x40c" placeholder="请输入出院其他诊断编码40" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断名称40" prop="c07x40n">
              <el-input v-model="queryParams.c07x40n" placeholder="请输入出院其他诊断名称40" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院其他诊断入院病情40" prop="c08x40c">
              <el-input v-model="queryParams.c08x40c" placeholder="请输入出院其他诊断入院病情40" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="病理诊断编码" prop="c09c">
              <el-input v-model="queryParams.c09c" placeholder="请输入病理诊断编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="病理诊断名称" prop="c10n">
              <el-input v-model="queryParams.c10n" placeholder="请输入病理诊断名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="病理号" prop="c11">
              <el-input v-model="queryParams.c11" placeholder="请输入病理号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="损伤、中毒外部原因编码" prop="c12c">
              <el-input v-model="queryParams.c12c" placeholder="请输入损伤、中毒外部原因编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="损伤、中毒外部原因名称" prop="c13n">
              <el-input v-model="queryParams.c13n" placeholder="请输入损伤、中毒外部原因名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="有无药物过敏" prop="c24c">
              <el-input v-model="queryParams.c24c" placeholder="请输入有无药物过敏" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="过敏药物名称" prop="c25">
              <el-input v-model="queryParams.c25" placeholder="请输入过敏药物名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="ABO血型" prop="c26c">
              <el-input v-model="queryParams.c26c" placeholder="请输入ABO血型" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="Rh血型" prop="c27c">
              <el-input v-model="queryParams.c27c" placeholder="请输入Rh血型" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="死亡患者尸检" prop="c34c">
              <el-input v-model="queryParams.c34c" placeholder="请输入死亡患者尸检" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="科主任" prop="b22">
              <el-input v-model="queryParams.b22" placeholder="请输入科主任" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主(副主)任医师" prop="b23">
              <el-input v-model="queryParams.b23" placeholder="请输入主(副主)任医师" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主治医师" prop="b24">
              <el-input v-model="queryParams.b24" placeholder="请输入主治医师" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="住院医师" prop="b25">
              <el-input v-model="queryParams.b25" placeholder="请输入住院医师" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="责任护士" prop="b26">
              <el-input v-model="queryParams.b26" placeholder="请输入责任护士" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="进修医师" prop="b27">
              <el-input v-model="queryParams.b27" placeholder="请输入进修医师" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="实习医师" prop="b28">
              <el-input v-model="queryParams.b28" placeholder="请输入实习医师" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="编码员" prop="b29">
              <el-input v-model="queryParams.b29" placeholder="请输入编码员" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="病案质量" prop="b30c">
              <el-input v-model="queryParams.b30c" placeholder="请输入病案质量" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="质控医师" prop="b31">
              <el-input v-model="queryParams.b31" placeholder="请输入质控医师" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="质控护师" prop="b32">
              <el-input v-model="queryParams.b32" placeholder="请输入质控护师" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="质控日期" prop="b33">
              <el-date-picker clearable
                v-model="queryParams.b33"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择质控日期"
              />
            </el-form-item>
            <el-form-item label="主要手术操作编码" prop="c14x01c">
              <el-input v-model="queryParams.c14x01c" placeholder="请输入主要手术操作编码" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作名称" prop="c15x01n">
              <el-input v-model="queryParams.c15x01n" placeholder="请输入主要手术操作名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作日期" prop="c16x01">
              <el-date-picker clearable
                v-model="queryParams.c16x01"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择主要手术操作日期"
              />
            </el-form-item>
            <el-form-item label="主要手术操作级别" prop="c17x01">
              <el-input v-model="queryParams.c17x01" placeholder="请输入主要手术操作级别" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作术者" prop="c18x01">
              <el-input v-model="queryParams.c18x01" placeholder="请输入主要手术操作术者" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作Ⅰ助" prop="c19x01">
              <el-input v-model="queryParams.c19x01" placeholder="请输入主要手术操作Ⅰ助" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作Ⅱ助" prop="c20x01">
              <el-input v-model="queryParams.c20x01" placeholder="请输入主要手术操作Ⅱ助" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作切口愈合等级" prop="c21x01c">
              <el-input v-model="queryParams.c21x01c" placeholder="请输入主要手术操作切口愈合等级" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作麻醉方式" prop="c22x01c">
              <el-input v-model="queryParams.c22x01c" placeholder="请输入主要手术操作麻醉方式" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作麻醉医师" prop="c23x01">
              <el-input v-model="queryParams.c23x01" placeholder="请输入主要手术操作麻醉医师" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="年龄不足1周岁的年龄(天)" prop="a16">
              <el-input v-model="queryParams.a16" placeholder="请输入年龄不足1周岁的年龄(天)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="新生儿出生体重(克)1" prop="a18x01">
              <el-input v-model="queryParams.a18x01" placeholder="请输入新生儿出生体重(克)1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="新生儿出生体重(克)2" prop="a18x02">
              <el-input v-model="queryParams.a18x02" placeholder="请输入新生儿出生体重(克)2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="新生儿出生体重(克)3" prop="a18x03">
              <el-input v-model="queryParams.a18x03" placeholder="请输入新生儿出生体重(克)3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="新生儿出生体重(克)4" prop="a18x04">
              <el-input v-model="queryParams.a18x04" placeholder="请输入新生儿出生体重(克)4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="新生儿出生体重(克)5" prop="a18x05">
              <el-input v-model="queryParams.a18x05" placeholder="请输入新生儿出生体重(克)5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="新生儿入院体重(克)" prop="a17">
              <el-input v-model="queryParams.a17" placeholder="请输入新生儿入院体重(克)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="颅脑损伤患者入院前昏迷时间(天)" prop="c28">
              <el-input v-model="queryParams.c28" placeholder="请输入颅脑损伤患者入院前昏迷时间(天)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="颅脑损伤患者入院前昏迷时间(小时)" prop="c29">
              <el-input v-model="queryParams.c29" placeholder="请输入颅脑损伤患者入院前昏迷时间(小时)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="颅脑损伤患者入院前昏迷时间(分钟)" prop="c30">
              <el-input v-model="queryParams.c30" placeholder="请输入颅脑损伤患者入院前昏迷时间(分钟)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="颅脑损伤患者入院后昏迷时间(天)" prop="c31">
              <el-input v-model="queryParams.c31" placeholder="请输入颅脑损伤患者入院后昏迷时间(天)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="颅脑损伤患者入院后昏迷时间(小时)" prop="c32">
              <el-input v-model="queryParams.c32" placeholder="请输入颅脑损伤患者入院后昏迷时间(小时)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="颅脑损伤患者入院后昏迷时间(分钟)" prop="c33">
              <el-input v-model="queryParams.c33" placeholder="请输入颅脑损伤患者入院后昏迷时间(分钟)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="是否有出院31日内再住院计划" prop="b36c">
              <el-input v-model="queryParams.b36c" placeholder="请输入是否有出院31日内再住院计划" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="出院31天再住院计划目的" prop="b37">
              <el-input v-model="queryParams.b37" placeholder="请输入出院31天再住院计划目的" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="离院方式" prop="b34c">
              <el-input v-model="queryParams.b34c" placeholder="请输入离院方式" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="医嘱转院、转社区卫生服务机构/乡镇卫生院名称" prop="b35">
              <el-input v-model="queryParams.b35" placeholder="请输入医嘱转院、转社区卫生服务机构/乡镇卫生院名称" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作编码2" prop="c14x02c">
              <el-input v-model="queryParams.c14x02c" placeholder="请输入主要手术操作编码2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作名称2" prop="c15x02n">
              <el-input v-model="queryParams.c15x02n" placeholder="请输入主要手术操作名称2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作日期2" prop="c16x02">
              <el-date-picker clearable
                v-model="queryParams.c16x02"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择主要手术操作日期2"
              />
            </el-form-item>
            <el-form-item label="主要手术操作级别2" prop="c17x02">
              <el-input v-model="queryParams.c17x02" placeholder="请输入主要手术操作级别2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作术者2" prop="c18x02">
              <el-input v-model="queryParams.c18x02" placeholder="请输入主要手术操作术者2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作Ⅰ助2" prop="c19x02">
              <el-input v-model="queryParams.c19x02" placeholder="请输入主要手术操作Ⅰ助2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作Ⅱ助2" prop="c20x02">
              <el-input v-model="queryParams.c20x02" placeholder="请输入主要手术操作Ⅱ助2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作切口愈合等级2" prop="c21x02c">
              <el-input v-model="queryParams.c21x02c" placeholder="请输入主要手术操作切口愈合等级2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作麻醉方式2" prop="c22x02c">
              <el-input v-model="queryParams.c22x02c" placeholder="请输入主要手术操作麻醉方式2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作麻醉医师2" prop="c23x02">
              <el-input v-model="queryParams.c23x02" placeholder="请输入主要手术操作麻醉医师2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作编码3" prop="c14x03c">
              <el-input v-model="queryParams.c14x03c" placeholder="请输入主要手术操作编码3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作名称3" prop="c15x03n">
              <el-input v-model="queryParams.c15x03n" placeholder="请输入主要手术操作名称3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作日期3" prop="c16x03">
              <el-date-picker clearable
                v-model="queryParams.c16x03"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择主要手术操作日期3"
              />
            </el-form-item>
            <el-form-item label="主要手术操作级别3" prop="c17x03">
              <el-input v-model="queryParams.c17x03" placeholder="请输入主要手术操作级别3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作术者3" prop="c18x03">
              <el-input v-model="queryParams.c18x03" placeholder="请输入主要手术操作术者3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作Ⅰ助3" prop="c19x03">
              <el-input v-model="queryParams.c19x03" placeholder="请输入主要手术操作Ⅰ助3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作Ⅱ助3" prop="c20x03">
              <el-input v-model="queryParams.c20x03" placeholder="请输入主要手术操作Ⅱ助3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作切口愈合等级3" prop="c21x03c">
              <el-input v-model="queryParams.c21x03c" placeholder="请输入主要手术操作切口愈合等级3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作麻醉方式3" prop="c22x03c">
              <el-input v-model="queryParams.c22x03c" placeholder="请输入主要手术操作麻醉方式3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作麻醉医师3" prop="c23x03">
              <el-input v-model="queryParams.c23x03" placeholder="请输入主要手术操作麻醉医师3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作编码4" prop="c14x04c">
              <el-input v-model="queryParams.c14x04c" placeholder="请输入主要手术操作编码4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作名称4" prop="c15x04n">
              <el-input v-model="queryParams.c15x04n" placeholder="请输入主要手术操作名称4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作日期4" prop="c16x04">
              <el-date-picker clearable
                v-model="queryParams.c16x04"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择主要手术操作日期4"
              />
            </el-form-item>
            <el-form-item label="主要手术操作级别4" prop="c17x04">
              <el-input v-model="queryParams.c17x04" placeholder="请输入主要手术操作级别4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作术者4" prop="c18x04">
              <el-input v-model="queryParams.c18x04" placeholder="请输入主要手术操作术者4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作Ⅰ助4" prop="c19x04">
              <el-input v-model="queryParams.c19x04" placeholder="请输入主要手术操作Ⅰ助4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作Ⅱ助4" prop="c20x04">
              <el-input v-model="queryParams.c20x04" placeholder="请输入主要手术操作Ⅱ助4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作切口愈合等级4" prop="c21x04c">
              <el-input v-model="queryParams.c21x04c" placeholder="请输入主要手术操作切口愈合等级4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作麻醉方式4" prop="c22x04c">
              <el-input v-model="queryParams.c22x04c" placeholder="请输入主要手术操作麻醉方式4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作麻醉医师4" prop="c23x04">
              <el-input v-model="queryParams.c23x04" placeholder="请输入主要手术操作麻醉医师4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作编码5" prop="c14x05c">
              <el-input v-model="queryParams.c14x05c" placeholder="请输入主要手术操作编码5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作名称5" prop="c15x05n">
              <el-input v-model="queryParams.c15x05n" placeholder="请输入主要手术操作名称5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作日期5" prop="c16x05">
              <el-date-picker clearable
                v-model="queryParams.c16x05"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择主要手术操作日期5"
              />
            </el-form-item>
            <el-form-item label="主要手术操作级别5" prop="c17x05">
              <el-input v-model="queryParams.c17x05" placeholder="请输入主要手术操作级别5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作术者5" prop="c18x05">
              <el-input v-model="queryParams.c18x05" placeholder="请输入主要手术操作术者5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作Ⅰ助5" prop="c19x05">
              <el-input v-model="queryParams.c19x05" placeholder="请输入主要手术操作Ⅰ助5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作Ⅱ助5" prop="c20x05">
              <el-input v-model="queryParams.c20x05" placeholder="请输入主要手术操作Ⅱ助5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作切口愈合等级5" prop="c21x05c">
              <el-input v-model="queryParams.c21x05c" placeholder="请输入主要手术操作切口愈合等级5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作麻醉方式5" prop="c22x05c">
              <el-input v-model="queryParams.c22x05c" placeholder="请输入主要手术操作麻醉方式5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作麻醉医师5" prop="c23x05">
              <el-input v-model="queryParams.c23x05" placeholder="请输入主要手术操作麻醉医师5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作编码6" prop="c14x06c">
              <el-input v-model="queryParams.c14x06c" placeholder="请输入主要手术操作编码6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作名称6" prop="c15x06n">
              <el-input v-model="queryParams.c15x06n" placeholder="请输入主要手术操作名称6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作日期6" prop="c16x06">
              <el-date-picker clearable
                v-model="queryParams.c16x06"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择主要手术操作日期6"
              />
            </el-form-item>
            <el-form-item label="主要手术操作级别6" prop="c17x06">
              <el-input v-model="queryParams.c17x06" placeholder="请输入主要手术操作级别6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作术者6" prop="c18x06">
              <el-input v-model="queryParams.c18x06" placeholder="请输入主要手术操作术者6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作Ⅰ助6" prop="c19x06">
              <el-input v-model="queryParams.c19x06" placeholder="请输入主要手术操作Ⅰ助6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作Ⅱ助6" prop="c20x06">
              <el-input v-model="queryParams.c20x06" placeholder="请输入主要手术操作Ⅱ助6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作切口愈合等级6" prop="c21x06c">
              <el-input v-model="queryParams.c21x06c" placeholder="请输入主要手术操作切口愈合等级6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作麻醉方式6" prop="c22x06c">
              <el-input v-model="queryParams.c22x06c" placeholder="请输入主要手术操作麻醉方式6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作麻醉医师6" prop="c23x06">
              <el-input v-model="queryParams.c23x06" placeholder="请输入主要手术操作麻醉医师6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作编码7" prop="c14x07c">
              <el-input v-model="queryParams.c14x07c" placeholder="请输入主要手术操作编码7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作名称7" prop="c15x07n">
              <el-input v-model="queryParams.c15x07n" placeholder="请输入主要手术操作名称7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作日期7" prop="c16x07">
              <el-date-picker clearable
                v-model="queryParams.c16x07"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择主要手术操作日期7"
              />
            </el-form-item>
            <el-form-item label="主要手术操作级别7" prop="c17x07">
              <el-input v-model="queryParams.c17x07" placeholder="请输入主要手术操作级别7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作术者7" prop="c18x07">
              <el-input v-model="queryParams.c18x07" placeholder="请输入主要手术操作术者7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作Ⅰ助7" prop="c19x07">
              <el-input v-model="queryParams.c19x07" placeholder="请输入主要手术操作Ⅰ助7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作Ⅱ助7" prop="c20x07">
              <el-input v-model="queryParams.c20x07" placeholder="请输入主要手术操作Ⅱ助7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作切口愈合等级7" prop="c21x07c">
              <el-input v-model="queryParams.c21x07c" placeholder="请输入主要手术操作切口愈合等级7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作麻醉方式7" prop="c22x07c">
              <el-input v-model="queryParams.c22x07c" placeholder="请输入主要手术操作麻醉方式7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作麻醉医师7" prop="c23x07">
              <el-input v-model="queryParams.c23x07" placeholder="请输入主要手术操作麻醉医师7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作编码8" prop="c14x08c">
              <el-input v-model="queryParams.c14x08c" placeholder="请输入主要手术操作编码8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作名称8" prop="c15x08n">
              <el-input v-model="queryParams.c15x08n" placeholder="请输入主要手术操作名称8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作日期8" prop="c16x08">
              <el-date-picker clearable
                v-model="queryParams.c16x08"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择主要手术操作日期8"
              />
            </el-form-item>
            <el-form-item label="主要手术操作级别8" prop="c17x08">
              <el-input v-model="queryParams.c17x08" placeholder="请输入主要手术操作级别8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作术者8" prop="c18x08">
              <el-input v-model="queryParams.c18x08" placeholder="请输入主要手术操作术者8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作Ⅰ助8" prop="c19x08">
              <el-input v-model="queryParams.c19x08" placeholder="请输入主要手术操作Ⅰ助8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作Ⅱ助8" prop="c20x08">
              <el-input v-model="queryParams.c20x08" placeholder="请输入主要手术操作Ⅱ助8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作切口愈合等级8" prop="c21x08c">
              <el-input v-model="queryParams.c21x08c" placeholder="请输入主要手术操作切口愈合等级8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作麻醉方式8" prop="c22x08c">
              <el-input v-model="queryParams.c22x08c" placeholder="请输入主要手术操作麻醉方式8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作麻醉医师8" prop="c23x08">
              <el-input v-model="queryParams.c23x08" placeholder="请输入主要手术操作麻醉医师8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作编码9" prop="c14x09c">
              <el-input v-model="queryParams.c14x09c" placeholder="请输入主要手术操作编码9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作名称9" prop="c15x09n">
              <el-input v-model="queryParams.c15x09n" placeholder="请输入主要手术操作名称9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作日期9" prop="c16x09">
              <el-date-picker clearable
                v-model="queryParams.c16x09"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择主要手术操作日期9"
              />
            </el-form-item>
            <el-form-item label="主要手术操作级别9" prop="c17x09">
              <el-input v-model="queryParams.c17x09" placeholder="请输入主要手术操作级别9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作术者9" prop="c18x09">
              <el-input v-model="queryParams.c18x09" placeholder="请输入主要手术操作术者9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作Ⅰ助9" prop="c19x09">
              <el-input v-model="queryParams.c19x09" placeholder="请输入主要手术操作Ⅰ助9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作Ⅱ助9" prop="c20x09">
              <el-input v-model="queryParams.c20x09" placeholder="请输入主要手术操作Ⅱ助9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作切口愈合等级9" prop="c21x09c">
              <el-input v-model="queryParams.c21x09c" placeholder="请输入主要手术操作切口愈合等级9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作麻醉方式9" prop="c22x09c">
              <el-input v-model="queryParams.c22x09c" placeholder="请输入主要手术操作麻醉方式9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作麻醉医师9" prop="c23x09">
              <el-input v-model="queryParams.c23x09" placeholder="请输入主要手术操作麻醉医师9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作编码10" prop="c14x10c">
              <el-input v-model="queryParams.c14x10c" placeholder="请输入主要手术操作编码10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作名称10" prop="c15x10n">
              <el-input v-model="queryParams.c15x10n" placeholder="请输入主要手术操作名称10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作日期10" prop="c16x10">
              <el-date-picker clearable
                v-model="queryParams.c16x10"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择主要手术操作日期10"
              />
            </el-form-item>
            <el-form-item label="主要手术操作级别10" prop="c17x10">
              <el-input v-model="queryParams.c17x10" placeholder="请输入主要手术操作级别10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作术者10" prop="c18x10">
              <el-input v-model="queryParams.c18x10" placeholder="请输入主要手术操作术者10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作Ⅰ助10" prop="c19x10">
              <el-input v-model="queryParams.c19x10" placeholder="请输入主要手术操作Ⅰ助10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作Ⅱ助10" prop="c20x10">
              <el-input v-model="queryParams.c20x10" placeholder="请输入主要手术操作Ⅱ助10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作切口愈合等级10" prop="c21x10c">
              <el-input v-model="queryParams.c21x10c" placeholder="请输入主要手术操作切口愈合等级10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作麻醉方式10" prop="c22x10c">
              <el-input v-model="queryParams.c22x10c" placeholder="请输入主要手术操作麻醉方式10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="主要手术操作麻醉医师10" prop="c23x10">
              <el-input v-model="queryParams.c23x10" placeholder="请输入主要手术操作麻醉医师10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item>
              <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
              <el-button icon="Refresh" @click="resetQuery">重置</el-button>
            </el-form-item>
          </el-form>
        </el-card>
      </div>
    </transition>

    <el-card shadow="never">
      <template #header>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['natdss:natdssB04MedicalRecordFrontSheetNonTcm:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['natdss:natdssB04MedicalRecordFrontSheetNonTcm:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['natdss:natdssB04MedicalRecordFrontSheetNonTcm:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['natdss:natdssB04MedicalRecordFrontSheetNonTcm:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="natdssB04MedicalRecordFrontSheetNonTcmList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="患者ID" align="center" prop="patientId" v-if="true" />
        <el-table-column label="单次就诊唯一标识号" align="center" prop="visitSn" v-if="true" />
        <el-table-column label="组织机构代码" align="center" prop="a01" />
        <el-table-column label="医疗机构名称" align="center" prop="a02" />
        <el-table-column label="病案号" align="center" prop="a48" />
        <el-table-column label="住院次数" align="center" prop="a49" />
        <el-table-column label="入院时间" align="center" prop="b12" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.b12, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="出院时间" align="center" prop="b15" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.b15, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="健康卡号" align="center" prop="a47" />
        <el-table-column label="医疗付费方式" align="center" prop="a46c" />
        <el-table-column label="姓名" align="center" prop="a11" />
        <el-table-column label="性别" align="center" prop="a12c" />
        <el-table-column label="出生日期" align="center" prop="a13" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.a13, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="年龄(岁)" align="center" prop="a14" />
        <el-table-column label="国籍" align="center" prop="a15c" />
        <el-table-column label="婚姻" align="center" prop="a21c" />
        <el-table-column label="职业" align="center" prop="a38c" />
        <el-table-column label="民族" align="center" prop="a19c" />
        <el-table-column label="身份证号" align="center" prop="a20" />
        <el-table-column label="出生地址" align="center" prop="a22" />
        <el-table-column label="籍贯省(自治区、直辖市)" align="center" prop="a23c" />
        <el-table-column label="户口地址" align="center" prop="a24" />
        <el-table-column label="户口地址邮政编码" align="center" prop="a25c" />
        <el-table-column label="现住址" align="center" prop="a26" />
        <el-table-column label="现住址电话" align="center" prop="a27" />
        <el-table-column label="现住址邮政编码" align="center" prop="a28c" />
        <el-table-column label="工作单位及地址" align="center" prop="a29" />
        <el-table-column label="工作单位电话" align="center" prop="a30" />
        <el-table-column label="工作单位邮政编码" align="center" prop="a31c" />
        <el-table-column label="联系人姓名" align="center" prop="a32" />
        <el-table-column label="联系人关系" align="center" prop="a33c" />
        <el-table-column label="联系人地址" align="center" prop="a34" />
        <el-table-column label="联系人电话" align="center" prop="a35" />
        <el-table-column label="入院途径" align="center" prop="b11c" />
        <el-table-column label="入院科别" align="center" prop="b13c" />
        <el-table-column label="入院病房" align="center" prop="b14" />
        <el-table-column label="转科科别" align="center" prop="b21c" />
        <el-table-column label="出院科别" align="center" prop="b16c" />
        <el-table-column label="出院病房" align="center" prop="b17" />
        <el-table-column label="实际住院(天)" align="center" prop="b20" />
        <el-table-column label="门(急)诊诊断编码" align="center" prop="c01c" />
        <el-table-column label="门(急)诊诊断名称" align="center" prop="c02n" />
        <el-table-column label="出院主要诊断编码" align="center" prop="c03c" />
        <el-table-column label="出院主要诊断名称" align="center" prop="c04n" />
        <el-table-column label="出院主要诊断入院病情" align="center" prop="c05c" />
        <el-table-column label="出院其他诊断编码1" align="center" prop="c06x01c" />
        <el-table-column label="出院其他诊断名称1" align="center" prop="c07x01n" />
        <el-table-column label="出院其他诊断入院病情1" align="center" prop="c08x01c" />
        <el-table-column label="出院其他诊断编码2" align="center" prop="c06x02c" />
        <el-table-column label="出院其他诊断名称2" align="center" prop="c07x02n" />
        <el-table-column label="出院其他诊断入院病情2" align="center" prop="c08x02c" />
        <el-table-column label="出院其他诊断编码3" align="center" prop="c06x03c" />
        <el-table-column label="出院其他诊断名称3" align="center" prop="c07x03n" />
        <el-table-column label="出院其他诊断入院病情3" align="center" prop="c08x03c" />
        <el-table-column label="出院其他诊断编码4" align="center" prop="c06x04c" />
        <el-table-column label="出院其他诊断名称4" align="center" prop="c07x04n" />
        <el-table-column label="出院其他诊断入院病情4" align="center" prop="c08x04c" />
        <el-table-column label="出院其他诊断编码5" align="center" prop="c06x05c" />
        <el-table-column label="出院其他诊断名称5" align="center" prop="c07x05n" />
        <el-table-column label="出院其他诊断入院病情5" align="center" prop="c08x05c" />
        <el-table-column label="出院其他诊断编码6" align="center" prop="c06x06c" />
        <el-table-column label="出院其他诊断名称6" align="center" prop="c07x06n" />
        <el-table-column label="出院其他诊断入院病情6" align="center" prop="c08x06c" />
        <el-table-column label="出院其他诊断编码7" align="center" prop="c06x07c" />
        <el-table-column label="出院其他诊断名称7" align="center" prop="c07x07n" />
        <el-table-column label="出院其他诊断入院病情7" align="center" prop="c08x07c" />
        <el-table-column label="出院其他诊断编码8" align="center" prop="c06x08c" />
        <el-table-column label="出院其他诊断名称8" align="center" prop="c07x08n" />
        <el-table-column label="出院其他诊断入院病情8" align="center" prop="c08x08c" />
        <el-table-column label="出院其他诊断编码9" align="center" prop="c06x09c" />
        <el-table-column label="出院其他诊断名称9" align="center" prop="c07x09n" />
        <el-table-column label="出院其他诊断入院病情9" align="center" prop="c08x09c" />
        <el-table-column label="出院其他诊断编码10" align="center" prop="c06x10c" />
        <el-table-column label="出院其他诊断名称10" align="center" prop="c07x10n" />
        <el-table-column label="出院其他诊断入院病情10" align="center" prop="c08x10c" />
        <el-table-column label="出院其他诊断编码11" align="center" prop="c06x11c" />
        <el-table-column label="出院其他诊断名称11" align="center" prop="c07x11n" />
        <el-table-column label="出院其他诊断入院病情11" align="center" prop="c08x11c" />
        <el-table-column label="出院其他诊断编码12" align="center" prop="c06x12c" />
        <el-table-column label="出院其他诊断名称12" align="center" prop="c07x12n" />
        <el-table-column label="出院其他诊断入院病情12" align="center" prop="c08x12c" />
        <el-table-column label="出院其他诊断编码13" align="center" prop="c06x13c" />
        <el-table-column label="出院其他诊断名称13" align="center" prop="c07x13n" />
        <el-table-column label="出院其他诊断入院病情13" align="center" prop="c08x13c" />
        <el-table-column label="出院其他诊断编码14" align="center" prop="c06x14c" />
        <el-table-column label="出院其他诊断名称14" align="center" prop="c07x14n" />
        <el-table-column label="出院其他诊断入院病情14" align="center" prop="c08x14c" />
        <el-table-column label="出院其他诊断编码15" align="center" prop="c06x15c" />
        <el-table-column label="出院其他诊断名称15" align="center" prop="c07x15n" />
        <el-table-column label="出院其他诊断入院病情15" align="center" prop="c08x15c" />
        <el-table-column label="出院其他诊断编码16" align="center" prop="c06x16c" />
        <el-table-column label="出院其他诊断名称16" align="center" prop="c07x16n" />
        <el-table-column label="出院其他诊断入院病情16" align="center" prop="c08x16c" />
        <el-table-column label="出院其他诊断编码17" align="center" prop="c06x17c" />
        <el-table-column label="出院其他诊断名称17" align="center" prop="c07x17n" />
        <el-table-column label="出院其他诊断入院病情17" align="center" prop="c08x17c" />
        <el-table-column label="出院其他诊断编码18" align="center" prop="c06x18c" />
        <el-table-column label="出院其他诊断名称18" align="center" prop="c07x18n" />
        <el-table-column label="出院其他诊断入院病情18" align="center" prop="c08x18c" />
        <el-table-column label="出院其他诊断编码19" align="center" prop="c06x19c" />
        <el-table-column label="出院其他诊断名称19" align="center" prop="c07x19n" />
        <el-table-column label="出院其他诊断入院病情19" align="center" prop="c08x19c" />
        <el-table-column label="出院其他诊断编码20" align="center" prop="c06x20c" />
        <el-table-column label="出院其他诊断名称20" align="center" prop="c07x20n" />
        <el-table-column label="出院其他诊断入院病情20" align="center" prop="c08x20c" />
        <el-table-column label="出院其他诊断编码21" align="center" prop="c06x21c" />
        <el-table-column label="出院其他诊断名称21" align="center" prop="c07x21n" />
        <el-table-column label="出院其他诊断入院病情21" align="center" prop="c08x21c" />
        <el-table-column label="出院其他诊断编码22" align="center" prop="c06x22c" />
        <el-table-column label="出院其他诊断名称22" align="center" prop="c07x22n" />
        <el-table-column label="出院其他诊断入院病情22" align="center" prop="c08x22c" />
        <el-table-column label="出院其他诊断编码23" align="center" prop="c06x23c" />
        <el-table-column label="出院其他诊断名称23" align="center" prop="c07x23n" />
        <el-table-column label="出院其他诊断入院病情23" align="center" prop="c08x23c" />
        <el-table-column label="出院其他诊断编码24" align="center" prop="c06x24c" />
        <el-table-column label="出院其他诊断名称24" align="center" prop="c07x24n" />
        <el-table-column label="出院其他诊断入院病情24" align="center" prop="c08x24c" />
        <el-table-column label="出院其他诊断编码25" align="center" prop="c06x25c" />
        <el-table-column label="出院其他诊断名称25" align="center" prop="c07x25n" />
        <el-table-column label="出院其他诊断入院病情25" align="center" prop="c08x25c" />
        <el-table-column label="出院其他诊断编码26" align="center" prop="c06x26c" />
        <el-table-column label="出院其他诊断名称26" align="center" prop="c07x26n" />
        <el-table-column label="出院其他诊断入院病情26" align="center" prop="c08x26c" />
        <el-table-column label="出院其他诊断编码27" align="center" prop="c06x27c" />
        <el-table-column label="出院其他诊断名称27" align="center" prop="c07x27n" />
        <el-table-column label="出院其他诊断入院病情27" align="center" prop="c08x27c" />
        <el-table-column label="出院其他诊断编码28" align="center" prop="c06x28c" />
        <el-table-column label="出院其他诊断名称28" align="center" prop="c07x28n" />
        <el-table-column label="出院其他诊断入院病情28" align="center" prop="c08x28c" />
        <el-table-column label="出院其他诊断编码29" align="center" prop="c06x29c" />
        <el-table-column label="出院其他诊断名称29" align="center" prop="c07x29n" />
        <el-table-column label="出院其他诊断入院病情29" align="center" prop="c08x29c" />
        <el-table-column label="出院其他诊断编码30" align="center" prop="c06x30c" />
        <el-table-column label="出院其他诊断名称30" align="center" prop="c07x30n" />
        <el-table-column label="出院其他诊断入院病情30" align="center" prop="c08x30c" />
        <el-table-column label="出院其他诊断编码31" align="center" prop="c06x31c" />
        <el-table-column label="出院其他诊断名称31" align="center" prop="c07x31n" />
        <el-table-column label="出院其他诊断入院病情31" align="center" prop="c08x31c" />
        <el-table-column label="出院其他诊断编码32" align="center" prop="c06x32c" />
        <el-table-column label="出院其他诊断名称32" align="center" prop="c07x32n" />
        <el-table-column label="出院其他诊断入院病情32" align="center" prop="c08x32c" />
        <el-table-column label="出院其他诊断编码33" align="center" prop="c06x33c" />
        <el-table-column label="出院其他诊断名称33" align="center" prop="c07x33n" />
        <el-table-column label="出院其他诊断入院病情33" align="center" prop="c08x33c" />
        <el-table-column label="出院其他诊断编码34" align="center" prop="c06x34c" />
        <el-table-column label="出院其他诊断名称34" align="center" prop="c07x34n" />
        <el-table-column label="出院其他诊断入院病情34" align="center" prop="c08x34c" />
        <el-table-column label="出院其他诊断编码35" align="center" prop="c06x35c" />
        <el-table-column label="出院其他诊断名称35" align="center" prop="c07x35n" />
        <el-table-column label="出院其他诊断入院病情35" align="center" prop="c08x35c" />
        <el-table-column label="出院其他诊断编码36" align="center" prop="c06x36c" />
        <el-table-column label="出院其他诊断名称36" align="center" prop="c07x36n" />
        <el-table-column label="出院其他诊断入院病情36" align="center" prop="c08x36c" />
        <el-table-column label="出院其他诊断编码37" align="center" prop="c06x37c" />
        <el-table-column label="出院其他诊断名称37" align="center" prop="c07x37n" />
        <el-table-column label="出院其他诊断入院病情37" align="center" prop="c08x37c" />
        <el-table-column label="出院其他诊断编码38" align="center" prop="c06x38c" />
        <el-table-column label="出院其他诊断名称38" align="center" prop="c07x38n" />
        <el-table-column label="出院其他诊断入院病情38" align="center" prop="c08x38c" />
        <el-table-column label="出院其他诊断编码39" align="center" prop="c06x39c" />
        <el-table-column label="出院其他诊断名称39" align="center" prop="c07x39n" />
        <el-table-column label="出院其他诊断入院病情39" align="center" prop="c08x39c" />
        <el-table-column label="出院其他诊断编码40" align="center" prop="c06x40c" />
        <el-table-column label="出院其他诊断名称40" align="center" prop="c07x40n" />
        <el-table-column label="出院其他诊断入院病情40" align="center" prop="c08x40c" />
        <el-table-column label="病理诊断编码" align="center" prop="c09c" />
        <el-table-column label="病理诊断名称" align="center" prop="c10n" />
        <el-table-column label="病理号" align="center" prop="c11" />
        <el-table-column label="损伤、中毒外部原因编码" align="center" prop="c12c" />
        <el-table-column label="损伤、中毒外部原因名称" align="center" prop="c13n" />
        <el-table-column label="有无药物过敏" align="center" prop="c24c" />
        <el-table-column label="过敏药物名称" align="center" prop="c25" />
        <el-table-column label="ABO血型" align="center" prop="c26c" />
        <el-table-column label="Rh血型" align="center" prop="c27c" />
        <el-table-column label="死亡患者尸检" align="center" prop="c34c" />
        <el-table-column label="科主任" align="center" prop="b22" />
        <el-table-column label="主(副主)任医师" align="center" prop="b23" />
        <el-table-column label="主治医师" align="center" prop="b24" />
        <el-table-column label="住院医师" align="center" prop="b25" />
        <el-table-column label="责任护士" align="center" prop="b26" />
        <el-table-column label="进修医师" align="center" prop="b27" />
        <el-table-column label="实习医师" align="center" prop="b28" />
        <el-table-column label="编码员" align="center" prop="b29" />
        <el-table-column label="病案质量" align="center" prop="b30c" />
        <el-table-column label="质控医师" align="center" prop="b31" />
        <el-table-column label="质控护师" align="center" prop="b32" />
        <el-table-column label="质控日期" align="center" prop="b33" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.b33, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="主要手术操作编码" align="center" prop="c14x01c" />
        <el-table-column label="主要手术操作名称" align="center" prop="c15x01n" />
        <el-table-column label="主要手术操作日期" align="center" prop="c16x01" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c16x01, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="主要手术操作级别" align="center" prop="c17x01" />
        <el-table-column label="主要手术操作术者" align="center" prop="c18x01" />
        <el-table-column label="主要手术操作Ⅰ助" align="center" prop="c19x01" />
        <el-table-column label="主要手术操作Ⅱ助" align="center" prop="c20x01" />
        <el-table-column label="主要手术操作切口愈合等级" align="center" prop="c21x01c" />
        <el-table-column label="主要手术操作麻醉方式" align="center" prop="c22x01c" />
        <el-table-column label="主要手术操作麻醉医师" align="center" prop="c23x01" />
        <el-table-column label="年龄不足1周岁的年龄(天)" align="center" prop="a16" />
        <el-table-column label="新生儿出生体重(克)1" align="center" prop="a18x01" />
        <el-table-column label="新生儿出生体重(克)2" align="center" prop="a18x02" />
        <el-table-column label="新生儿出生体重(克)3" align="center" prop="a18x03" />
        <el-table-column label="新生儿出生体重(克)4" align="center" prop="a18x04" />
        <el-table-column label="新生儿出生体重(克)5" align="center" prop="a18x05" />
        <el-table-column label="新生儿入院体重(克)" align="center" prop="a17" />
        <el-table-column label="颅脑损伤患者入院前昏迷时间(天)" align="center" prop="c28" />
        <el-table-column label="颅脑损伤患者入院前昏迷时间(小时)" align="center" prop="c29" />
        <el-table-column label="颅脑损伤患者入院前昏迷时间(分钟)" align="center" prop="c30" />
        <el-table-column label="颅脑损伤患者入院后昏迷时间(天)" align="center" prop="c31" />
        <el-table-column label="颅脑损伤患者入院后昏迷时间(小时)" align="center" prop="c32" />
        <el-table-column label="颅脑损伤患者入院后昏迷时间(分钟)" align="center" prop="c33" />
        <el-table-column label="是否有出院31日内再住院计划" align="center" prop="b36c" />
        <el-table-column label="出院31天再住院计划目的" align="center" prop="b37" />
        <el-table-column label="离院方式" align="center" prop="b34c" />
        <el-table-column label="医嘱转院、转社区卫生服务机构/乡镇卫生院名称" align="center" prop="b35" />
        <el-table-column label="主要手术操作编码2" align="center" prop="c14x02c" />
        <el-table-column label="主要手术操作名称2" align="center" prop="c15x02n" />
        <el-table-column label="主要手术操作日期2" align="center" prop="c16x02" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c16x02, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="主要手术操作级别2" align="center" prop="c17x02" />
        <el-table-column label="主要手术操作术者2" align="center" prop="c18x02" />
        <el-table-column label="主要手术操作Ⅰ助2" align="center" prop="c19x02" />
        <el-table-column label="主要手术操作Ⅱ助2" align="center" prop="c20x02" />
        <el-table-column label="主要手术操作切口愈合等级2" align="center" prop="c21x02c" />
        <el-table-column label="主要手术操作麻醉方式2" align="center" prop="c22x02c" />
        <el-table-column label="主要手术操作麻醉医师2" align="center" prop="c23x02" />
        <el-table-column label="主要手术操作编码3" align="center" prop="c14x03c" />
        <el-table-column label="主要手术操作名称3" align="center" prop="c15x03n" />
        <el-table-column label="主要手术操作日期3" align="center" prop="c16x03" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c16x03, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="主要手术操作级别3" align="center" prop="c17x03" />
        <el-table-column label="主要手术操作术者3" align="center" prop="c18x03" />
        <el-table-column label="主要手术操作Ⅰ助3" align="center" prop="c19x03" />
        <el-table-column label="主要手术操作Ⅱ助3" align="center" prop="c20x03" />
        <el-table-column label="主要手术操作切口愈合等级3" align="center" prop="c21x03c" />
        <el-table-column label="主要手术操作麻醉方式3" align="center" prop="c22x03c" />
        <el-table-column label="主要手术操作麻醉医师3" align="center" prop="c23x03" />
        <el-table-column label="主要手术操作编码4" align="center" prop="c14x04c" />
        <el-table-column label="主要手术操作名称4" align="center" prop="c15x04n" />
        <el-table-column label="主要手术操作日期4" align="center" prop="c16x04" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c16x04, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="主要手术操作级别4" align="center" prop="c17x04" />
        <el-table-column label="主要手术操作术者4" align="center" prop="c18x04" />
        <el-table-column label="主要手术操作Ⅰ助4" align="center" prop="c19x04" />
        <el-table-column label="主要手术操作Ⅱ助4" align="center" prop="c20x04" />
        <el-table-column label="主要手术操作切口愈合等级4" align="center" prop="c21x04c" />
        <el-table-column label="主要手术操作麻醉方式4" align="center" prop="c22x04c" />
        <el-table-column label="主要手术操作麻醉医师4" align="center" prop="c23x04" />
        <el-table-column label="主要手术操作编码5" align="center" prop="c14x05c" />
        <el-table-column label="主要手术操作名称5" align="center" prop="c15x05n" />
        <el-table-column label="主要手术操作日期5" align="center" prop="c16x05" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c16x05, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="主要手术操作级别5" align="center" prop="c17x05" />
        <el-table-column label="主要手术操作术者5" align="center" prop="c18x05" />
        <el-table-column label="主要手术操作Ⅰ助5" align="center" prop="c19x05" />
        <el-table-column label="主要手术操作Ⅱ助5" align="center" prop="c20x05" />
        <el-table-column label="主要手术操作切口愈合等级5" align="center" prop="c21x05c" />
        <el-table-column label="主要手术操作麻醉方式5" align="center" prop="c22x05c" />
        <el-table-column label="主要手术操作麻醉医师5" align="center" prop="c23x05" />
        <el-table-column label="主要手术操作编码6" align="center" prop="c14x06c" />
        <el-table-column label="主要手术操作名称6" align="center" prop="c15x06n" />
        <el-table-column label="主要手术操作日期6" align="center" prop="c16x06" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c16x06, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="主要手术操作级别6" align="center" prop="c17x06" />
        <el-table-column label="主要手术操作术者6" align="center" prop="c18x06" />
        <el-table-column label="主要手术操作Ⅰ助6" align="center" prop="c19x06" />
        <el-table-column label="主要手术操作Ⅱ助6" align="center" prop="c20x06" />
        <el-table-column label="主要手术操作切口愈合等级6" align="center" prop="c21x06c" />
        <el-table-column label="主要手术操作麻醉方式6" align="center" prop="c22x06c" />
        <el-table-column label="主要手术操作麻醉医师6" align="center" prop="c23x06" />
        <el-table-column label="主要手术操作编码7" align="center" prop="c14x07c" />
        <el-table-column label="主要手术操作名称7" align="center" prop="c15x07n" />
        <el-table-column label="主要手术操作日期7" align="center" prop="c16x07" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c16x07, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="主要手术操作级别7" align="center" prop="c17x07" />
        <el-table-column label="主要手术操作术者7" align="center" prop="c18x07" />
        <el-table-column label="主要手术操作Ⅰ助7" align="center" prop="c19x07" />
        <el-table-column label="主要手术操作Ⅱ助7" align="center" prop="c20x07" />
        <el-table-column label="主要手术操作切口愈合等级7" align="center" prop="c21x07c" />
        <el-table-column label="主要手术操作麻醉方式7" align="center" prop="c22x07c" />
        <el-table-column label="主要手术操作麻醉医师7" align="center" prop="c23x07" />
        <el-table-column label="主要手术操作编码8" align="center" prop="c14x08c" />
        <el-table-column label="主要手术操作名称8" align="center" prop="c15x08n" />
        <el-table-column label="主要手术操作日期8" align="center" prop="c16x08" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c16x08, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="主要手术操作级别8" align="center" prop="c17x08" />
        <el-table-column label="主要手术操作术者8" align="center" prop="c18x08" />
        <el-table-column label="主要手术操作Ⅰ助8" align="center" prop="c19x08" />
        <el-table-column label="主要手术操作Ⅱ助8" align="center" prop="c20x08" />
        <el-table-column label="主要手术操作切口愈合等级8" align="center" prop="c21x08c" />
        <el-table-column label="主要手术操作麻醉方式8" align="center" prop="c22x08c" />
        <el-table-column label="主要手术操作麻醉医师8" align="center" prop="c23x08" />
        <el-table-column label="主要手术操作编码9" align="center" prop="c14x09c" />
        <el-table-column label="主要手术操作名称9" align="center" prop="c15x09n" />
        <el-table-column label="主要手术操作日期9" align="center" prop="c16x09" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c16x09, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="主要手术操作级别9" align="center" prop="c17x09" />
        <el-table-column label="主要手术操作术者9" align="center" prop="c18x09" />
        <el-table-column label="主要手术操作Ⅰ助9" align="center" prop="c19x09" />
        <el-table-column label="主要手术操作Ⅱ助9" align="center" prop="c20x09" />
        <el-table-column label="主要手术操作切口愈合等级9" align="center" prop="c21x09c" />
        <el-table-column label="主要手术操作麻醉方式9" align="center" prop="c22x09c" />
        <el-table-column label="主要手术操作麻醉医师9" align="center" prop="c23x09" />
        <el-table-column label="主要手术操作编码10" align="center" prop="c14x10c" />
        <el-table-column label="主要手术操作名称10" align="center" prop="c15x10n" />
        <el-table-column label="主要手术操作日期10" align="center" prop="c16x10" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c16x10, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="主要手术操作级别10" align="center" prop="c17x10" />
        <el-table-column label="主要手术操作术者10" align="center" prop="c18x10" />
        <el-table-column label="主要手术操作Ⅰ助10" align="center" prop="c19x10" />
        <el-table-column label="主要手术操作Ⅱ助10" align="center" prop="c20x10" />
        <el-table-column label="主要手术操作切口愈合等级10" align="center" prop="c21x10c" />
        <el-table-column label="主要手术操作麻醉方式10" align="center" prop="c22x10c" />
        <el-table-column label="主要手术操作麻醉医师10" align="center" prop="c23x10" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['natdss:natdssB04MedicalRecordFrontSheetNonTcm:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['natdss:natdssB04MedicalRecordFrontSheetNonTcm:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改B04病历首页-核心信息-非中医院（基础+诊断+主要手术）对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="natdssB04MedicalRecordFrontSheetNonTcmFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="组织机构代码" prop="a01">
          <el-input v-model="form.a01" placeholder="请输入组织机构代码" />
        </el-form-item>
        <el-form-item label="医疗机构名称" prop="a02">
          <el-input v-model="form.a02" placeholder="请输入医疗机构名称" />
        </el-form-item>
        <el-form-item label="病案号" prop="a48">
          <el-input v-model="form.a48" placeholder="请输入病案号" />
        </el-form-item>
        <el-form-item label="住院次数" prop="a49">
          <el-input v-model="form.a49" placeholder="请输入住院次数" />
        </el-form-item>
        <el-form-item label="入院时间" prop="b12">
          <el-date-picker clearable
            v-model="form.b12"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择入院时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="出院时间" prop="b15">
          <el-date-picker clearable
            v-model="form.b15"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择出院时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="健康卡号" prop="a47">
          <el-input v-model="form.a47" placeholder="请输入健康卡号" />
        </el-form-item>
        <el-form-item label="医疗付费方式" prop="a46c">
          <el-input v-model="form.a46c" placeholder="请输入医疗付费方式" />
        </el-form-item>
        <el-form-item label="姓名" prop="a11">
          <el-input v-model="form.a11" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="性别" prop="a12c">
          <el-input v-model="form.a12c" placeholder="请输入性别" />
        </el-form-item>
        <el-form-item label="出生日期" prop="a13">
          <el-date-picker clearable
            v-model="form.a13"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择出生日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="年龄(岁)" prop="a14">
          <el-input v-model="form.a14" placeholder="请输入年龄(岁)" />
        </el-form-item>
        <el-form-item label="国籍" prop="a15c">
          <el-input v-model="form.a15c" placeholder="请输入国籍" />
        </el-form-item>
        <el-form-item label="婚姻" prop="a21c">
          <el-input v-model="form.a21c" placeholder="请输入婚姻" />
        </el-form-item>
        <el-form-item label="职业" prop="a38c">
          <el-input v-model="form.a38c" placeholder="请输入职业" />
        </el-form-item>
        <el-form-item label="民族" prop="a19c">
          <el-input v-model="form.a19c" placeholder="请输入民族" />
        </el-form-item>
        <el-form-item label="身份证号" prop="a20">
          <el-input v-model="form.a20" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="出生地址" prop="a22">
          <el-input v-model="form.a22" placeholder="请输入出生地址" />
        </el-form-item>
        <el-form-item label="籍贯省(自治区、直辖市)" prop="a23c">
          <el-input v-model="form.a23c" placeholder="请输入籍贯省(自治区、直辖市)" />
        </el-form-item>
        <el-form-item label="户口地址" prop="a24">
          <el-input v-model="form.a24" placeholder="请输入户口地址" />
        </el-form-item>
        <el-form-item label="户口地址邮政编码" prop="a25c">
          <el-input v-model="form.a25c" placeholder="请输入户口地址邮政编码" />
        </el-form-item>
        <el-form-item label="现住址" prop="a26">
          <el-input v-model="form.a26" placeholder="请输入现住址" />
        </el-form-item>
        <el-form-item label="现住址电话" prop="a27">
          <el-input v-model="form.a27" placeholder="请输入现住址电话" />
        </el-form-item>
        <el-form-item label="现住址邮政编码" prop="a28c">
          <el-input v-model="form.a28c" placeholder="请输入现住址邮政编码" />
        </el-form-item>
        <el-form-item label="工作单位及地址" prop="a29">
          <el-input v-model="form.a29" placeholder="请输入工作单位及地址" />
        </el-form-item>
        <el-form-item label="工作单位电话" prop="a30">
          <el-input v-model="form.a30" placeholder="请输入工作单位电话" />
        </el-form-item>
        <el-form-item label="工作单位邮政编码" prop="a31c">
          <el-input v-model="form.a31c" placeholder="请输入工作单位邮政编码" />
        </el-form-item>
        <el-form-item label="联系人姓名" prop="a32">
          <el-input v-model="form.a32" placeholder="请输入联系人姓名" />
        </el-form-item>
        <el-form-item label="联系人关系" prop="a33c">
          <el-input v-model="form.a33c" placeholder="请输入联系人关系" />
        </el-form-item>
        <el-form-item label="联系人地址" prop="a34">
          <el-input v-model="form.a34" placeholder="请输入联系人地址" />
        </el-form-item>
        <el-form-item label="联系人电话" prop="a35">
          <el-input v-model="form.a35" placeholder="请输入联系人电话" />
        </el-form-item>
        <el-form-item label="入院途径" prop="b11c">
          <el-input v-model="form.b11c" placeholder="请输入入院途径" />
        </el-form-item>
        <el-form-item label="入院科别" prop="b13c">
          <el-input v-model="form.b13c" placeholder="请输入入院科别" />
        </el-form-item>
        <el-form-item label="入院病房" prop="b14">
          <el-input v-model="form.b14" placeholder="请输入入院病房" />
        </el-form-item>
        <el-form-item label="转科科别" prop="b21c">
          <el-input v-model="form.b21c" placeholder="请输入转科科别" />
        </el-form-item>
        <el-form-item label="出院科别" prop="b16c">
          <el-input v-model="form.b16c" placeholder="请输入出院科别" />
        </el-form-item>
        <el-form-item label="出院病房" prop="b17">
          <el-input v-model="form.b17" placeholder="请输入出院病房" />
        </el-form-item>
        <el-form-item label="实际住院(天)" prop="b20">
          <el-input v-model="form.b20" placeholder="请输入实际住院(天)" />
        </el-form-item>
        <el-form-item label="门(急)诊诊断编码" prop="c01c">
          <el-input v-model="form.c01c" placeholder="请输入门(急)诊诊断编码" />
        </el-form-item>
        <el-form-item label="门(急)诊诊断名称" prop="c02n">
          <el-input v-model="form.c02n" placeholder="请输入门(急)诊诊断名称" />
        </el-form-item>
        <el-form-item label="出院主要诊断编码" prop="c03c">
          <el-input v-model="form.c03c" placeholder="请输入出院主要诊断编码" />
        </el-form-item>
        <el-form-item label="出院主要诊断名称" prop="c04n">
          <el-input v-model="form.c04n" placeholder="请输入出院主要诊断名称" />
        </el-form-item>
        <el-form-item label="出院主要诊断入院病情" prop="c05c">
          <el-input v-model="form.c05c" placeholder="请输入出院主要诊断入院病情" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码1" prop="c06x01c">
          <el-input v-model="form.c06x01c" placeholder="请输入出院其他诊断编码1" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称1" prop="c07x01n">
          <el-input v-model="form.c07x01n" placeholder="请输入出院其他诊断名称1" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情1" prop="c08x01c">
          <el-input v-model="form.c08x01c" placeholder="请输入出院其他诊断入院病情1" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码2" prop="c06x02c">
          <el-input v-model="form.c06x02c" placeholder="请输入出院其他诊断编码2" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称2" prop="c07x02n">
          <el-input v-model="form.c07x02n" placeholder="请输入出院其他诊断名称2" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情2" prop="c08x02c">
          <el-input v-model="form.c08x02c" placeholder="请输入出院其他诊断入院病情2" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码3" prop="c06x03c">
          <el-input v-model="form.c06x03c" placeholder="请输入出院其他诊断编码3" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称3" prop="c07x03n">
          <el-input v-model="form.c07x03n" placeholder="请输入出院其他诊断名称3" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情3" prop="c08x03c">
          <el-input v-model="form.c08x03c" placeholder="请输入出院其他诊断入院病情3" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码4" prop="c06x04c">
          <el-input v-model="form.c06x04c" placeholder="请输入出院其他诊断编码4" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称4" prop="c07x04n">
          <el-input v-model="form.c07x04n" placeholder="请输入出院其他诊断名称4" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情4" prop="c08x04c">
          <el-input v-model="form.c08x04c" placeholder="请输入出院其他诊断入院病情4" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码5" prop="c06x05c">
          <el-input v-model="form.c06x05c" placeholder="请输入出院其他诊断编码5" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称5" prop="c07x05n">
          <el-input v-model="form.c07x05n" placeholder="请输入出院其他诊断名称5" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情5" prop="c08x05c">
          <el-input v-model="form.c08x05c" placeholder="请输入出院其他诊断入院病情5" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码6" prop="c06x06c">
          <el-input v-model="form.c06x06c" placeholder="请输入出院其他诊断编码6" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称6" prop="c07x06n">
          <el-input v-model="form.c07x06n" placeholder="请输入出院其他诊断名称6" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情6" prop="c08x06c">
          <el-input v-model="form.c08x06c" placeholder="请输入出院其他诊断入院病情6" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码7" prop="c06x07c">
          <el-input v-model="form.c06x07c" placeholder="请输入出院其他诊断编码7" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称7" prop="c07x07n">
          <el-input v-model="form.c07x07n" placeholder="请输入出院其他诊断名称7" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情7" prop="c08x07c">
          <el-input v-model="form.c08x07c" placeholder="请输入出院其他诊断入院病情7" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码8" prop="c06x08c">
          <el-input v-model="form.c06x08c" placeholder="请输入出院其他诊断编码8" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称8" prop="c07x08n">
          <el-input v-model="form.c07x08n" placeholder="请输入出院其他诊断名称8" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情8" prop="c08x08c">
          <el-input v-model="form.c08x08c" placeholder="请输入出院其他诊断入院病情8" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码9" prop="c06x09c">
          <el-input v-model="form.c06x09c" placeholder="请输入出院其他诊断编码9" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称9" prop="c07x09n">
          <el-input v-model="form.c07x09n" placeholder="请输入出院其他诊断名称9" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情9" prop="c08x09c">
          <el-input v-model="form.c08x09c" placeholder="请输入出院其他诊断入院病情9" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码10" prop="c06x10c">
          <el-input v-model="form.c06x10c" placeholder="请输入出院其他诊断编码10" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称10" prop="c07x10n">
          <el-input v-model="form.c07x10n" placeholder="请输入出院其他诊断名称10" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情10" prop="c08x10c">
          <el-input v-model="form.c08x10c" placeholder="请输入出院其他诊断入院病情10" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码11" prop="c06x11c">
          <el-input v-model="form.c06x11c" placeholder="请输入出院其他诊断编码11" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称11" prop="c07x11n">
          <el-input v-model="form.c07x11n" placeholder="请输入出院其他诊断名称11" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情11" prop="c08x11c">
          <el-input v-model="form.c08x11c" placeholder="请输入出院其他诊断入院病情11" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码12" prop="c06x12c">
          <el-input v-model="form.c06x12c" placeholder="请输入出院其他诊断编码12" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称12" prop="c07x12n">
          <el-input v-model="form.c07x12n" placeholder="请输入出院其他诊断名称12" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情12" prop="c08x12c">
          <el-input v-model="form.c08x12c" placeholder="请输入出院其他诊断入院病情12" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码13" prop="c06x13c">
          <el-input v-model="form.c06x13c" placeholder="请输入出院其他诊断编码13" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称13" prop="c07x13n">
          <el-input v-model="form.c07x13n" placeholder="请输入出院其他诊断名称13" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情13" prop="c08x13c">
          <el-input v-model="form.c08x13c" placeholder="请输入出院其他诊断入院病情13" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码14" prop="c06x14c">
          <el-input v-model="form.c06x14c" placeholder="请输入出院其他诊断编码14" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称14" prop="c07x14n">
          <el-input v-model="form.c07x14n" placeholder="请输入出院其他诊断名称14" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情14" prop="c08x14c">
          <el-input v-model="form.c08x14c" placeholder="请输入出院其他诊断入院病情14" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码15" prop="c06x15c">
          <el-input v-model="form.c06x15c" placeholder="请输入出院其他诊断编码15" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称15" prop="c07x15n">
          <el-input v-model="form.c07x15n" placeholder="请输入出院其他诊断名称15" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情15" prop="c08x15c">
          <el-input v-model="form.c08x15c" placeholder="请输入出院其他诊断入院病情15" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码16" prop="c06x16c">
          <el-input v-model="form.c06x16c" placeholder="请输入出院其他诊断编码16" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称16" prop="c07x16n">
          <el-input v-model="form.c07x16n" placeholder="请输入出院其他诊断名称16" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情16" prop="c08x16c">
          <el-input v-model="form.c08x16c" placeholder="请输入出院其他诊断入院病情16" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码17" prop="c06x17c">
          <el-input v-model="form.c06x17c" placeholder="请输入出院其他诊断编码17" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称17" prop="c07x17n">
          <el-input v-model="form.c07x17n" placeholder="请输入出院其他诊断名称17" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情17" prop="c08x17c">
          <el-input v-model="form.c08x17c" placeholder="请输入出院其他诊断入院病情17" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码18" prop="c06x18c">
          <el-input v-model="form.c06x18c" placeholder="请输入出院其他诊断编码18" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称18" prop="c07x18n">
          <el-input v-model="form.c07x18n" placeholder="请输入出院其他诊断名称18" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情18" prop="c08x18c">
          <el-input v-model="form.c08x18c" placeholder="请输入出院其他诊断入院病情18" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码19" prop="c06x19c">
          <el-input v-model="form.c06x19c" placeholder="请输入出院其他诊断编码19" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称19" prop="c07x19n">
          <el-input v-model="form.c07x19n" placeholder="请输入出院其他诊断名称19" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情19" prop="c08x19c">
          <el-input v-model="form.c08x19c" placeholder="请输入出院其他诊断入院病情19" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码20" prop="c06x20c">
          <el-input v-model="form.c06x20c" placeholder="请输入出院其他诊断编码20" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称20" prop="c07x20n">
          <el-input v-model="form.c07x20n" placeholder="请输入出院其他诊断名称20" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情20" prop="c08x20c">
          <el-input v-model="form.c08x20c" placeholder="请输入出院其他诊断入院病情20" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码21" prop="c06x21c">
          <el-input v-model="form.c06x21c" placeholder="请输入出院其他诊断编码21" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称21" prop="c07x21n">
          <el-input v-model="form.c07x21n" placeholder="请输入出院其他诊断名称21" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情21" prop="c08x21c">
          <el-input v-model="form.c08x21c" placeholder="请输入出院其他诊断入院病情21" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码22" prop="c06x22c">
          <el-input v-model="form.c06x22c" placeholder="请输入出院其他诊断编码22" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称22" prop="c07x22n">
          <el-input v-model="form.c07x22n" placeholder="请输入出院其他诊断名称22" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情22" prop="c08x22c">
          <el-input v-model="form.c08x22c" placeholder="请输入出院其他诊断入院病情22" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码23" prop="c06x23c">
          <el-input v-model="form.c06x23c" placeholder="请输入出院其他诊断编码23" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称23" prop="c07x23n">
          <el-input v-model="form.c07x23n" placeholder="请输入出院其他诊断名称23" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情23" prop="c08x23c">
          <el-input v-model="form.c08x23c" placeholder="请输入出院其他诊断入院病情23" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码24" prop="c06x24c">
          <el-input v-model="form.c06x24c" placeholder="请输入出院其他诊断编码24" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称24" prop="c07x24n">
          <el-input v-model="form.c07x24n" placeholder="请输入出院其他诊断名称24" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情24" prop="c08x24c">
          <el-input v-model="form.c08x24c" placeholder="请输入出院其他诊断入院病情24" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码25" prop="c06x25c">
          <el-input v-model="form.c06x25c" placeholder="请输入出院其他诊断编码25" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称25" prop="c07x25n">
          <el-input v-model="form.c07x25n" placeholder="请输入出院其他诊断名称25" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情25" prop="c08x25c">
          <el-input v-model="form.c08x25c" placeholder="请输入出院其他诊断入院病情25" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码26" prop="c06x26c">
          <el-input v-model="form.c06x26c" placeholder="请输入出院其他诊断编码26" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称26" prop="c07x26n">
          <el-input v-model="form.c07x26n" placeholder="请输入出院其他诊断名称26" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情26" prop="c08x26c">
          <el-input v-model="form.c08x26c" placeholder="请输入出院其他诊断入院病情26" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码27" prop="c06x27c">
          <el-input v-model="form.c06x27c" placeholder="请输入出院其他诊断编码27" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称27" prop="c07x27n">
          <el-input v-model="form.c07x27n" placeholder="请输入出院其他诊断名称27" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情27" prop="c08x27c">
          <el-input v-model="form.c08x27c" placeholder="请输入出院其他诊断入院病情27" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码28" prop="c06x28c">
          <el-input v-model="form.c06x28c" placeholder="请输入出院其他诊断编码28" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称28" prop="c07x28n">
          <el-input v-model="form.c07x28n" placeholder="请输入出院其他诊断名称28" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情28" prop="c08x28c">
          <el-input v-model="form.c08x28c" placeholder="请输入出院其他诊断入院病情28" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码29" prop="c06x29c">
          <el-input v-model="form.c06x29c" placeholder="请输入出院其他诊断编码29" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称29" prop="c07x29n">
          <el-input v-model="form.c07x29n" placeholder="请输入出院其他诊断名称29" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情29" prop="c08x29c">
          <el-input v-model="form.c08x29c" placeholder="请输入出院其他诊断入院病情29" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码30" prop="c06x30c">
          <el-input v-model="form.c06x30c" placeholder="请输入出院其他诊断编码30" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称30" prop="c07x30n">
          <el-input v-model="form.c07x30n" placeholder="请输入出院其他诊断名称30" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情30" prop="c08x30c">
          <el-input v-model="form.c08x30c" placeholder="请输入出院其他诊断入院病情30" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码31" prop="c06x31c">
          <el-input v-model="form.c06x31c" placeholder="请输入出院其他诊断编码31" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称31" prop="c07x31n">
          <el-input v-model="form.c07x31n" placeholder="请输入出院其他诊断名称31" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情31" prop="c08x31c">
          <el-input v-model="form.c08x31c" placeholder="请输入出院其他诊断入院病情31" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码32" prop="c06x32c">
          <el-input v-model="form.c06x32c" placeholder="请输入出院其他诊断编码32" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称32" prop="c07x32n">
          <el-input v-model="form.c07x32n" placeholder="请输入出院其他诊断名称32" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情32" prop="c08x32c">
          <el-input v-model="form.c08x32c" placeholder="请输入出院其他诊断入院病情32" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码33" prop="c06x33c">
          <el-input v-model="form.c06x33c" placeholder="请输入出院其他诊断编码33" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称33" prop="c07x33n">
          <el-input v-model="form.c07x33n" placeholder="请输入出院其他诊断名称33" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情33" prop="c08x33c">
          <el-input v-model="form.c08x33c" placeholder="请输入出院其他诊断入院病情33" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码34" prop="c06x34c">
          <el-input v-model="form.c06x34c" placeholder="请输入出院其他诊断编码34" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称34" prop="c07x34n">
          <el-input v-model="form.c07x34n" placeholder="请输入出院其他诊断名称34" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情34" prop="c08x34c">
          <el-input v-model="form.c08x34c" placeholder="请输入出院其他诊断入院病情34" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码35" prop="c06x35c">
          <el-input v-model="form.c06x35c" placeholder="请输入出院其他诊断编码35" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称35" prop="c07x35n">
          <el-input v-model="form.c07x35n" placeholder="请输入出院其他诊断名称35" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情35" prop="c08x35c">
          <el-input v-model="form.c08x35c" placeholder="请输入出院其他诊断入院病情35" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码36" prop="c06x36c">
          <el-input v-model="form.c06x36c" placeholder="请输入出院其他诊断编码36" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称36" prop="c07x36n">
          <el-input v-model="form.c07x36n" placeholder="请输入出院其他诊断名称36" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情36" prop="c08x36c">
          <el-input v-model="form.c08x36c" placeholder="请输入出院其他诊断入院病情36" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码37" prop="c06x37c">
          <el-input v-model="form.c06x37c" placeholder="请输入出院其他诊断编码37" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称37" prop="c07x37n">
          <el-input v-model="form.c07x37n" placeholder="请输入出院其他诊断名称37" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情37" prop="c08x37c">
          <el-input v-model="form.c08x37c" placeholder="请输入出院其他诊断入院病情37" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码38" prop="c06x38c">
          <el-input v-model="form.c06x38c" placeholder="请输入出院其他诊断编码38" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称38" prop="c07x38n">
          <el-input v-model="form.c07x38n" placeholder="请输入出院其他诊断名称38" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情38" prop="c08x38c">
          <el-input v-model="form.c08x38c" placeholder="请输入出院其他诊断入院病情38" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码39" prop="c06x39c">
          <el-input v-model="form.c06x39c" placeholder="请输入出院其他诊断编码39" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称39" prop="c07x39n">
          <el-input v-model="form.c07x39n" placeholder="请输入出院其他诊断名称39" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情39" prop="c08x39c">
          <el-input v-model="form.c08x39c" placeholder="请输入出院其他诊断入院病情39" />
        </el-form-item>
        <el-form-item label="出院其他诊断编码40" prop="c06x40c">
          <el-input v-model="form.c06x40c" placeholder="请输入出院其他诊断编码40" />
        </el-form-item>
        <el-form-item label="出院其他诊断名称40" prop="c07x40n">
          <el-input v-model="form.c07x40n" placeholder="请输入出院其他诊断名称40" />
        </el-form-item>
        <el-form-item label="出院其他诊断入院病情40" prop="c08x40c">
          <el-input v-model="form.c08x40c" placeholder="请输入出院其他诊断入院病情40" />
        </el-form-item>
        <el-form-item label="病理诊断编码" prop="c09c">
          <el-input v-model="form.c09c" placeholder="请输入病理诊断编码" />
        </el-form-item>
        <el-form-item label="病理诊断名称" prop="c10n">
          <el-input v-model="form.c10n" placeholder="请输入病理诊断名称" />
        </el-form-item>
        <el-form-item label="病理号" prop="c11">
          <el-input v-model="form.c11" placeholder="请输入病理号" />
        </el-form-item>
        <el-form-item label="损伤、中毒外部原因编码" prop="c12c">
          <el-input v-model="form.c12c" placeholder="请输入损伤、中毒外部原因编码" />
        </el-form-item>
        <el-form-item label="损伤、中毒外部原因名称" prop="c13n">
          <el-input v-model="form.c13n" placeholder="请输入损伤、中毒外部原因名称" />
        </el-form-item>
        <el-form-item label="有无药物过敏" prop="c24c">
          <el-input v-model="form.c24c" placeholder="请输入有无药物过敏" />
        </el-form-item>
        <el-form-item label="过敏药物名称" prop="c25">
          <el-input v-model="form.c25" placeholder="请输入过敏药物名称" />
        </el-form-item>
        <el-form-item label="ABO血型" prop="c26c">
          <el-input v-model="form.c26c" placeholder="请输入ABO血型" />
        </el-form-item>
        <el-form-item label="Rh血型" prop="c27c">
          <el-input v-model="form.c27c" placeholder="请输入Rh血型" />
        </el-form-item>
        <el-form-item label="死亡患者尸检" prop="c34c">
          <el-input v-model="form.c34c" placeholder="请输入死亡患者尸检" />
        </el-form-item>
        <el-form-item label="科主任" prop="b22">
          <el-input v-model="form.b22" placeholder="请输入科主任" />
        </el-form-item>
        <el-form-item label="主(副主)任医师" prop="b23">
          <el-input v-model="form.b23" placeholder="请输入主(副主)任医师" />
        </el-form-item>
        <el-form-item label="主治医师" prop="b24">
          <el-input v-model="form.b24" placeholder="请输入主治医师" />
        </el-form-item>
        <el-form-item label="住院医师" prop="b25">
          <el-input v-model="form.b25" placeholder="请输入住院医师" />
        </el-form-item>
        <el-form-item label="责任护士" prop="b26">
          <el-input v-model="form.b26" placeholder="请输入责任护士" />
        </el-form-item>
        <el-form-item label="进修医师" prop="b27">
          <el-input v-model="form.b27" placeholder="请输入进修医师" />
        </el-form-item>
        <el-form-item label="实习医师" prop="b28">
          <el-input v-model="form.b28" placeholder="请输入实习医师" />
        </el-form-item>
        <el-form-item label="编码员" prop="b29">
          <el-input v-model="form.b29" placeholder="请输入编码员" />
        </el-form-item>
        <el-form-item label="病案质量" prop="b30c">
          <el-input v-model="form.b30c" placeholder="请输入病案质量" />
        </el-form-item>
        <el-form-item label="质控医师" prop="b31">
          <el-input v-model="form.b31" placeholder="请输入质控医师" />
        </el-form-item>
        <el-form-item label="质控护师" prop="b32">
          <el-input v-model="form.b32" placeholder="请输入质控护师" />
        </el-form-item>
        <el-form-item label="质控日期" prop="b33">
          <el-date-picker clearable
            v-model="form.b33"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择质控日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="主要手术操作编码" prop="c14x01c">
          <el-input v-model="form.c14x01c" placeholder="请输入主要手术操作编码" />
        </el-form-item>
        <el-form-item label="主要手术操作名称" prop="c15x01n">
          <el-input v-model="form.c15x01n" placeholder="请输入主要手术操作名称" />
        </el-form-item>
        <el-form-item label="主要手术操作日期" prop="c16x01">
          <el-date-picker clearable
            v-model="form.c16x01"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择主要手术操作日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="主要手术操作级别" prop="c17x01">
          <el-input v-model="form.c17x01" placeholder="请输入主要手术操作级别" />
        </el-form-item>
        <el-form-item label="主要手术操作术者" prop="c18x01">
          <el-input v-model="form.c18x01" placeholder="请输入主要手术操作术者" />
        </el-form-item>
        <el-form-item label="主要手术操作Ⅰ助" prop="c19x01">
          <el-input v-model="form.c19x01" placeholder="请输入主要手术操作Ⅰ助" />
        </el-form-item>
        <el-form-item label="主要手术操作Ⅱ助" prop="c20x01">
          <el-input v-model="form.c20x01" placeholder="请输入主要手术操作Ⅱ助" />
        </el-form-item>
        <el-form-item label="主要手术操作切口愈合等级" prop="c21x01c">
          <el-input v-model="form.c21x01c" placeholder="请输入主要手术操作切口愈合等级" />
        </el-form-item>
        <el-form-item label="主要手术操作麻醉方式" prop="c22x01c">
          <el-input v-model="form.c22x01c" placeholder="请输入主要手术操作麻醉方式" />
        </el-form-item>
        <el-form-item label="主要手术操作麻醉医师" prop="c23x01">
          <el-input v-model="form.c23x01" placeholder="请输入主要手术操作麻醉医师" />
        </el-form-item>
        <el-form-item label="年龄不足1周岁的年龄(天)" prop="a16">
          <el-input v-model="form.a16" placeholder="请输入年龄不足1周岁的年龄(天)" />
        </el-form-item>
        <el-form-item label="新生儿出生体重(克)1" prop="a18x01">
          <el-input v-model="form.a18x01" placeholder="请输入新生儿出生体重(克)1" />
        </el-form-item>
        <el-form-item label="新生儿出生体重(克)2" prop="a18x02">
          <el-input v-model="form.a18x02" placeholder="请输入新生儿出生体重(克)2" />
        </el-form-item>
        <el-form-item label="新生儿出生体重(克)3" prop="a18x03">
          <el-input v-model="form.a18x03" placeholder="请输入新生儿出生体重(克)3" />
        </el-form-item>
        <el-form-item label="新生儿出生体重(克)4" prop="a18x04">
          <el-input v-model="form.a18x04" placeholder="请输入新生儿出生体重(克)4" />
        </el-form-item>
        <el-form-item label="新生儿出生体重(克)5" prop="a18x05">
          <el-input v-model="form.a18x05" placeholder="请输入新生儿出生体重(克)5" />
        </el-form-item>
        <el-form-item label="新生儿入院体重(克)" prop="a17">
          <el-input v-model="form.a17" placeholder="请输入新生儿入院体重(克)" />
        </el-form-item>
        <el-form-item label="颅脑损伤患者入院前昏迷时间(天)" prop="c28">
          <el-input v-model="form.c28" placeholder="请输入颅脑损伤患者入院前昏迷时间(天)" />
        </el-form-item>
        <el-form-item label="颅脑损伤患者入院前昏迷时间(小时)" prop="c29">
          <el-input v-model="form.c29" placeholder="请输入颅脑损伤患者入院前昏迷时间(小时)" />
        </el-form-item>
        <el-form-item label="颅脑损伤患者入院前昏迷时间(分钟)" prop="c30">
          <el-input v-model="form.c30" placeholder="请输入颅脑损伤患者入院前昏迷时间(分钟)" />
        </el-form-item>
        <el-form-item label="颅脑损伤患者入院后昏迷时间(天)" prop="c31">
          <el-input v-model="form.c31" placeholder="请输入颅脑损伤患者入院后昏迷时间(天)" />
        </el-form-item>
        <el-form-item label="颅脑损伤患者入院后昏迷时间(小时)" prop="c32">
          <el-input v-model="form.c32" placeholder="请输入颅脑损伤患者入院后昏迷时间(小时)" />
        </el-form-item>
        <el-form-item label="颅脑损伤患者入院后昏迷时间(分钟)" prop="c33">
          <el-input v-model="form.c33" placeholder="请输入颅脑损伤患者入院后昏迷时间(分钟)" />
        </el-form-item>
        <el-form-item label="是否有出院31日内再住院计划" prop="b36c">
          <el-input v-model="form.b36c" placeholder="请输入是否有出院31日内再住院计划" />
        </el-form-item>
        <el-form-item label="出院31天再住院计划目的" prop="b37">
          <el-input v-model="form.b37" placeholder="请输入出院31天再住院计划目的" />
        </el-form-item>
        <el-form-item label="离院方式" prop="b34c">
          <el-input v-model="form.b34c" placeholder="请输入离院方式" />
        </el-form-item>
        <el-form-item label="医嘱转院、转社区卫生服务机构/乡镇卫生院名称" prop="b35">
          <el-input v-model="form.b35" placeholder="请输入医嘱转院、转社区卫生服务机构/乡镇卫生院名称" />
        </el-form-item>
        <el-form-item label="主要手术操作编码2" prop="c14x02c">
          <el-input v-model="form.c14x02c" placeholder="请输入主要手术操作编码2" />
        </el-form-item>
        <el-form-item label="主要手术操作名称2" prop="c15x02n">
          <el-input v-model="form.c15x02n" placeholder="请输入主要手术操作名称2" />
        </el-form-item>
        <el-form-item label="主要手术操作日期2" prop="c16x02">
          <el-date-picker clearable
            v-model="form.c16x02"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择主要手术操作日期2">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="主要手术操作级别2" prop="c17x02">
          <el-input v-model="form.c17x02" placeholder="请输入主要手术操作级别2" />
        </el-form-item>
        <el-form-item label="主要手术操作术者2" prop="c18x02">
          <el-input v-model="form.c18x02" placeholder="请输入主要手术操作术者2" />
        </el-form-item>
        <el-form-item label="主要手术操作Ⅰ助2" prop="c19x02">
          <el-input v-model="form.c19x02" placeholder="请输入主要手术操作Ⅰ助2" />
        </el-form-item>
        <el-form-item label="主要手术操作Ⅱ助2" prop="c20x02">
          <el-input v-model="form.c20x02" placeholder="请输入主要手术操作Ⅱ助2" />
        </el-form-item>
        <el-form-item label="主要手术操作切口愈合等级2" prop="c21x02c">
          <el-input v-model="form.c21x02c" placeholder="请输入主要手术操作切口愈合等级2" />
        </el-form-item>
        <el-form-item label="主要手术操作麻醉方式2" prop="c22x02c">
          <el-input v-model="form.c22x02c" placeholder="请输入主要手术操作麻醉方式2" />
        </el-form-item>
        <el-form-item label="主要手术操作麻醉医师2" prop="c23x02">
          <el-input v-model="form.c23x02" placeholder="请输入主要手术操作麻醉医师2" />
        </el-form-item>
        <el-form-item label="主要手术操作编码3" prop="c14x03c">
          <el-input v-model="form.c14x03c" placeholder="请输入主要手术操作编码3" />
        </el-form-item>
        <el-form-item label="主要手术操作名称3" prop="c15x03n">
          <el-input v-model="form.c15x03n" placeholder="请输入主要手术操作名称3" />
        </el-form-item>
        <el-form-item label="主要手术操作日期3" prop="c16x03">
          <el-date-picker clearable
            v-model="form.c16x03"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择主要手术操作日期3">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="主要手术操作级别3" prop="c17x03">
          <el-input v-model="form.c17x03" placeholder="请输入主要手术操作级别3" />
        </el-form-item>
        <el-form-item label="主要手术操作术者3" prop="c18x03">
          <el-input v-model="form.c18x03" placeholder="请输入主要手术操作术者3" />
        </el-form-item>
        <el-form-item label="主要手术操作Ⅰ助3" prop="c19x03">
          <el-input v-model="form.c19x03" placeholder="请输入主要手术操作Ⅰ助3" />
        </el-form-item>
        <el-form-item label="主要手术操作Ⅱ助3" prop="c20x03">
          <el-input v-model="form.c20x03" placeholder="请输入主要手术操作Ⅱ助3" />
        </el-form-item>
        <el-form-item label="主要手术操作切口愈合等级3" prop="c21x03c">
          <el-input v-model="form.c21x03c" placeholder="请输入主要手术操作切口愈合等级3" />
        </el-form-item>
        <el-form-item label="主要手术操作麻醉方式3" prop="c22x03c">
          <el-input v-model="form.c22x03c" placeholder="请输入主要手术操作麻醉方式3" />
        </el-form-item>
        <el-form-item label="主要手术操作麻醉医师3" prop="c23x03">
          <el-input v-model="form.c23x03" placeholder="请输入主要手术操作麻醉医师3" />
        </el-form-item>
        <el-form-item label="主要手术操作编码4" prop="c14x04c">
          <el-input v-model="form.c14x04c" placeholder="请输入主要手术操作编码4" />
        </el-form-item>
        <el-form-item label="主要手术操作名称4" prop="c15x04n">
          <el-input v-model="form.c15x04n" placeholder="请输入主要手术操作名称4" />
        </el-form-item>
        <el-form-item label="主要手术操作日期4" prop="c16x04">
          <el-date-picker clearable
            v-model="form.c16x04"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择主要手术操作日期4">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="主要手术操作级别4" prop="c17x04">
          <el-input v-model="form.c17x04" placeholder="请输入主要手术操作级别4" />
        </el-form-item>
        <el-form-item label="主要手术操作术者4" prop="c18x04">
          <el-input v-model="form.c18x04" placeholder="请输入主要手术操作术者4" />
        </el-form-item>
        <el-form-item label="主要手术操作Ⅰ助4" prop="c19x04">
          <el-input v-model="form.c19x04" placeholder="请输入主要手术操作Ⅰ助4" />
        </el-form-item>
        <el-form-item label="主要手术操作Ⅱ助4" prop="c20x04">
          <el-input v-model="form.c20x04" placeholder="请输入主要手术操作Ⅱ助4" />
        </el-form-item>
        <el-form-item label="主要手术操作切口愈合等级4" prop="c21x04c">
          <el-input v-model="form.c21x04c" placeholder="请输入主要手术操作切口愈合等级4" />
        </el-form-item>
        <el-form-item label="主要手术操作麻醉方式4" prop="c22x04c">
          <el-input v-model="form.c22x04c" placeholder="请输入主要手术操作麻醉方式4" />
        </el-form-item>
        <el-form-item label="主要手术操作麻醉医师4" prop="c23x04">
          <el-input v-model="form.c23x04" placeholder="请输入主要手术操作麻醉医师4" />
        </el-form-item>
        <el-form-item label="主要手术操作编码5" prop="c14x05c">
          <el-input v-model="form.c14x05c" placeholder="请输入主要手术操作编码5" />
        </el-form-item>
        <el-form-item label="主要手术操作名称5" prop="c15x05n">
          <el-input v-model="form.c15x05n" placeholder="请输入主要手术操作名称5" />
        </el-form-item>
        <el-form-item label="主要手术操作日期5" prop="c16x05">
          <el-date-picker clearable
            v-model="form.c16x05"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择主要手术操作日期5">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="主要手术操作级别5" prop="c17x05">
          <el-input v-model="form.c17x05" placeholder="请输入主要手术操作级别5" />
        </el-form-item>
        <el-form-item label="主要手术操作术者5" prop="c18x05">
          <el-input v-model="form.c18x05" placeholder="请输入主要手术操作术者5" />
        </el-form-item>
        <el-form-item label="主要手术操作Ⅰ助5" prop="c19x05">
          <el-input v-model="form.c19x05" placeholder="请输入主要手术操作Ⅰ助5" />
        </el-form-item>
        <el-form-item label="主要手术操作Ⅱ助5" prop="c20x05">
          <el-input v-model="form.c20x05" placeholder="请输入主要手术操作Ⅱ助5" />
        </el-form-item>
        <el-form-item label="主要手术操作切口愈合等级5" prop="c21x05c">
          <el-input v-model="form.c21x05c" placeholder="请输入主要手术操作切口愈合等级5" />
        </el-form-item>
        <el-form-item label="主要手术操作麻醉方式5" prop="c22x05c">
          <el-input v-model="form.c22x05c" placeholder="请输入主要手术操作麻醉方式5" />
        </el-form-item>
        <el-form-item label="主要手术操作麻醉医师5" prop="c23x05">
          <el-input v-model="form.c23x05" placeholder="请输入主要手术操作麻醉医师5" />
        </el-form-item>
        <el-form-item label="主要手术操作编码6" prop="c14x06c">
          <el-input v-model="form.c14x06c" placeholder="请输入主要手术操作编码6" />
        </el-form-item>
        <el-form-item label="主要手术操作名称6" prop="c15x06n">
          <el-input v-model="form.c15x06n" placeholder="请输入主要手术操作名称6" />
        </el-form-item>
        <el-form-item label="主要手术操作日期6" prop="c16x06">
          <el-date-picker clearable
            v-model="form.c16x06"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择主要手术操作日期6">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="主要手术操作级别6" prop="c17x06">
          <el-input v-model="form.c17x06" placeholder="请输入主要手术操作级别6" />
        </el-form-item>
        <el-form-item label="主要手术操作术者6" prop="c18x06">
          <el-input v-model="form.c18x06" placeholder="请输入主要手术操作术者6" />
        </el-form-item>
        <el-form-item label="主要手术操作Ⅰ助6" prop="c19x06">
          <el-input v-model="form.c19x06" placeholder="请输入主要手术操作Ⅰ助6" />
        </el-form-item>
        <el-form-item label="主要手术操作Ⅱ助6" prop="c20x06">
          <el-input v-model="form.c20x06" placeholder="请输入主要手术操作Ⅱ助6" />
        </el-form-item>
        <el-form-item label="主要手术操作切口愈合等级6" prop="c21x06c">
          <el-input v-model="form.c21x06c" placeholder="请输入主要手术操作切口愈合等级6" />
        </el-form-item>
        <el-form-item label="主要手术操作麻醉方式6" prop="c22x06c">
          <el-input v-model="form.c22x06c" placeholder="请输入主要手术操作麻醉方式6" />
        </el-form-item>
        <el-form-item label="主要手术操作麻醉医师6" prop="c23x06">
          <el-input v-model="form.c23x06" placeholder="请输入主要手术操作麻醉医师6" />
        </el-form-item>
        <el-form-item label="主要手术操作编码7" prop="c14x07c">
          <el-input v-model="form.c14x07c" placeholder="请输入主要手术操作编码7" />
        </el-form-item>
        <el-form-item label="主要手术操作名称7" prop="c15x07n">
          <el-input v-model="form.c15x07n" placeholder="请输入主要手术操作名称7" />
        </el-form-item>
        <el-form-item label="主要手术操作日期7" prop="c16x07">
          <el-date-picker clearable
            v-model="form.c16x07"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择主要手术操作日期7">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="主要手术操作级别7" prop="c17x07">
          <el-input v-model="form.c17x07" placeholder="请输入主要手术操作级别7" />
        </el-form-item>
        <el-form-item label="主要手术操作术者7" prop="c18x07">
          <el-input v-model="form.c18x07" placeholder="请输入主要手术操作术者7" />
        </el-form-item>
        <el-form-item label="主要手术操作Ⅰ助7" prop="c19x07">
          <el-input v-model="form.c19x07" placeholder="请输入主要手术操作Ⅰ助7" />
        </el-form-item>
        <el-form-item label="主要手术操作Ⅱ助7" prop="c20x07">
          <el-input v-model="form.c20x07" placeholder="请输入主要手术操作Ⅱ助7" />
        </el-form-item>
        <el-form-item label="主要手术操作切口愈合等级7" prop="c21x07c">
          <el-input v-model="form.c21x07c" placeholder="请输入主要手术操作切口愈合等级7" />
        </el-form-item>
        <el-form-item label="主要手术操作麻醉方式7" prop="c22x07c">
          <el-input v-model="form.c22x07c" placeholder="请输入主要手术操作麻醉方式7" />
        </el-form-item>
        <el-form-item label="主要手术操作麻醉医师7" prop="c23x07">
          <el-input v-model="form.c23x07" placeholder="请输入主要手术操作麻醉医师7" />
        </el-form-item>
        <el-form-item label="主要手术操作编码8" prop="c14x08c">
          <el-input v-model="form.c14x08c" placeholder="请输入主要手术操作编码8" />
        </el-form-item>
        <el-form-item label="主要手术操作名称8" prop="c15x08n">
          <el-input v-model="form.c15x08n" placeholder="请输入主要手术操作名称8" />
        </el-form-item>
        <el-form-item label="主要手术操作日期8" prop="c16x08">
          <el-date-picker clearable
            v-model="form.c16x08"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择主要手术操作日期8">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="主要手术操作级别8" prop="c17x08">
          <el-input v-model="form.c17x08" placeholder="请输入主要手术操作级别8" />
        </el-form-item>
        <el-form-item label="主要手术操作术者8" prop="c18x08">
          <el-input v-model="form.c18x08" placeholder="请输入主要手术操作术者8" />
        </el-form-item>
        <el-form-item label="主要手术操作Ⅰ助8" prop="c19x08">
          <el-input v-model="form.c19x08" placeholder="请输入主要手术操作Ⅰ助8" />
        </el-form-item>
        <el-form-item label="主要手术操作Ⅱ助8" prop="c20x08">
          <el-input v-model="form.c20x08" placeholder="请输入主要手术操作Ⅱ助8" />
        </el-form-item>
        <el-form-item label="主要手术操作切口愈合等级8" prop="c21x08c">
          <el-input v-model="form.c21x08c" placeholder="请输入主要手术操作切口愈合等级8" />
        </el-form-item>
        <el-form-item label="主要手术操作麻醉方式8" prop="c22x08c">
          <el-input v-model="form.c22x08c" placeholder="请输入主要手术操作麻醉方式8" />
        </el-form-item>
        <el-form-item label="主要手术操作麻醉医师8" prop="c23x08">
          <el-input v-model="form.c23x08" placeholder="请输入主要手术操作麻醉医师8" />
        </el-form-item>
        <el-form-item label="主要手术操作编码9" prop="c14x09c">
          <el-input v-model="form.c14x09c" placeholder="请输入主要手术操作编码9" />
        </el-form-item>
        <el-form-item label="主要手术操作名称9" prop="c15x09n">
          <el-input v-model="form.c15x09n" placeholder="请输入主要手术操作名称9" />
        </el-form-item>
        <el-form-item label="主要手术操作日期9" prop="c16x09">
          <el-date-picker clearable
            v-model="form.c16x09"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择主要手术操作日期9">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="主要手术操作级别9" prop="c17x09">
          <el-input v-model="form.c17x09" placeholder="请输入主要手术操作级别9" />
        </el-form-item>
        <el-form-item label="主要手术操作术者9" prop="c18x09">
          <el-input v-model="form.c18x09" placeholder="请输入主要手术操作术者9" />
        </el-form-item>
        <el-form-item label="主要手术操作Ⅰ助9" prop="c19x09">
          <el-input v-model="form.c19x09" placeholder="请输入主要手术操作Ⅰ助9" />
        </el-form-item>
        <el-form-item label="主要手术操作Ⅱ助9" prop="c20x09">
          <el-input v-model="form.c20x09" placeholder="请输入主要手术操作Ⅱ助9" />
        </el-form-item>
        <el-form-item label="主要手术操作切口愈合等级9" prop="c21x09c">
          <el-input v-model="form.c21x09c" placeholder="请输入主要手术操作切口愈合等级9" />
        </el-form-item>
        <el-form-item label="主要手术操作麻醉方式9" prop="c22x09c">
          <el-input v-model="form.c22x09c" placeholder="请输入主要手术操作麻醉方式9" />
        </el-form-item>
        <el-form-item label="主要手术操作麻醉医师9" prop="c23x09">
          <el-input v-model="form.c23x09" placeholder="请输入主要手术操作麻醉医师9" />
        </el-form-item>
        <el-form-item label="主要手术操作编码10" prop="c14x10c">
          <el-input v-model="form.c14x10c" placeholder="请输入主要手术操作编码10" />
        </el-form-item>
        <el-form-item label="主要手术操作名称10" prop="c15x10n">
          <el-input v-model="form.c15x10n" placeholder="请输入主要手术操作名称10" />
        </el-form-item>
        <el-form-item label="主要手术操作日期10" prop="c16x10">
          <el-date-picker clearable
            v-model="form.c16x10"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择主要手术操作日期10">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="主要手术操作级别10" prop="c17x10">
          <el-input v-model="form.c17x10" placeholder="请输入主要手术操作级别10" />
        </el-form-item>
        <el-form-item label="主要手术操作术者10" prop="c18x10">
          <el-input v-model="form.c18x10" placeholder="请输入主要手术操作术者10" />
        </el-form-item>
        <el-form-item label="主要手术操作Ⅰ助10" prop="c19x10">
          <el-input v-model="form.c19x10" placeholder="请输入主要手术操作Ⅰ助10" />
        </el-form-item>
        <el-form-item label="主要手术操作Ⅱ助10" prop="c20x10">
          <el-input v-model="form.c20x10" placeholder="请输入主要手术操作Ⅱ助10" />
        </el-form-item>
        <el-form-item label="主要手术操作切口愈合等级10" prop="c21x10c">
          <el-input v-model="form.c21x10c" placeholder="请输入主要手术操作切口愈合等级10" />
        </el-form-item>
        <el-form-item label="主要手术操作麻醉方式10" prop="c22x10c">
          <el-input v-model="form.c22x10c" placeholder="请输入主要手术操作麻醉方式10" />
        </el-form-item>
        <el-form-item label="主要手术操作麻醉医师10" prop="c23x10">
          <el-input v-model="form.c23x10" placeholder="请输入主要手术操作麻醉医师10" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="NatdssB04MedicalRecordFrontSheetNonTcm" lang="ts">
import { listNatdssB04MedicalRecordFrontSheetNonTcm, getNatdssB04MedicalRecordFrontSheetNonTcm, delNatdssB04MedicalRecordFrontSheetNonTcm, addNatdssB04MedicalRecordFrontSheetNonTcm, updateNatdssB04MedicalRecordFrontSheetNonTcm } from '@/api/natdss/natdssB04MedicalRecordFrontSheetNonTcm';
import { NatdssB04MedicalRecordFrontSheetNonTcmVO, NatdssB04MedicalRecordFrontSheetNonTcmQuery, NatdssB04MedicalRecordFrontSheetNonTcmForm } from '@/api/natdss/natdssB04MedicalRecordFrontSheetNonTcm/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const natdssB04MedicalRecordFrontSheetNonTcmList = ref<NatdssB04MedicalRecordFrontSheetNonTcmVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const natdssB04MedicalRecordFrontSheetNonTcmFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NatdssB04MedicalRecordFrontSheetNonTcmForm = {
  patientId: undefined,
  visitSn: undefined,
  a01: undefined,
  a02: undefined,
  a48: undefined,
  a49: undefined,
  b12: undefined,
  b15: undefined,
  a47: undefined,
  a46c: undefined,
  a11: undefined,
  a12c: undefined,
  a13: undefined,
  a14: undefined,
  a15c: undefined,
  a21c: undefined,
  a38c: undefined,
  a19c: undefined,
  a20: undefined,
  a22: undefined,
  a23c: undefined,
  a24: undefined,
  a25c: undefined,
  a26: undefined,
  a27: undefined,
  a28c: undefined,
  a29: undefined,
  a30: undefined,
  a31c: undefined,
  a32: undefined,
  a33c: undefined,
  a34: undefined,
  a35: undefined,
  b11c: undefined,
  b13c: undefined,
  b14: undefined,
  b21c: undefined,
  b16c: undefined,
  b17: undefined,
  b20: undefined,
  c01c: undefined,
  c02n: undefined,
  c03c: undefined,
  c04n: undefined,
  c05c: undefined,
  c06x01c: undefined,
  c07x01n: undefined,
  c08x01c: undefined,
  c06x02c: undefined,
  c07x02n: undefined,
  c08x02c: undefined,
  c06x03c: undefined,
  c07x03n: undefined,
  c08x03c: undefined,
  c06x04c: undefined,
  c07x04n: undefined,
  c08x04c: undefined,
  c06x05c: undefined,
  c07x05n: undefined,
  c08x05c: undefined,
  c06x06c: undefined,
  c07x06n: undefined,
  c08x06c: undefined,
  c06x07c: undefined,
  c07x07n: undefined,
  c08x07c: undefined,
  c06x08c: undefined,
  c07x08n: undefined,
  c08x08c: undefined,
  c06x09c: undefined,
  c07x09n: undefined,
  c08x09c: undefined,
  c06x10c: undefined,
  c07x10n: undefined,
  c08x10c: undefined,
  c06x11c: undefined,
  c07x11n: undefined,
  c08x11c: undefined,
  c06x12c: undefined,
  c07x12n: undefined,
  c08x12c: undefined,
  c06x13c: undefined,
  c07x13n: undefined,
  c08x13c: undefined,
  c06x14c: undefined,
  c07x14n: undefined,
  c08x14c: undefined,
  c06x15c: undefined,
  c07x15n: undefined,
  c08x15c: undefined,
  c06x16c: undefined,
  c07x16n: undefined,
  c08x16c: undefined,
  c06x17c: undefined,
  c07x17n: undefined,
  c08x17c: undefined,
  c06x18c: undefined,
  c07x18n: undefined,
  c08x18c: undefined,
  c06x19c: undefined,
  c07x19n: undefined,
  c08x19c: undefined,
  c06x20c: undefined,
  c07x20n: undefined,
  c08x20c: undefined,
  c06x21c: undefined,
  c07x21n: undefined,
  c08x21c: undefined,
  c06x22c: undefined,
  c07x22n: undefined,
  c08x22c: undefined,
  c06x23c: undefined,
  c07x23n: undefined,
  c08x23c: undefined,
  c06x24c: undefined,
  c07x24n: undefined,
  c08x24c: undefined,
  c06x25c: undefined,
  c07x25n: undefined,
  c08x25c: undefined,
  c06x26c: undefined,
  c07x26n: undefined,
  c08x26c: undefined,
  c06x27c: undefined,
  c07x27n: undefined,
  c08x27c: undefined,
  c06x28c: undefined,
  c07x28n: undefined,
  c08x28c: undefined,
  c06x29c: undefined,
  c07x29n: undefined,
  c08x29c: undefined,
  c06x30c: undefined,
  c07x30n: undefined,
  c08x30c: undefined,
  c06x31c: undefined,
  c07x31n: undefined,
  c08x31c: undefined,
  c06x32c: undefined,
  c07x32n: undefined,
  c08x32c: undefined,
  c06x33c: undefined,
  c07x33n: undefined,
  c08x33c: undefined,
  c06x34c: undefined,
  c07x34n: undefined,
  c08x34c: undefined,
  c06x35c: undefined,
  c07x35n: undefined,
  c08x35c: undefined,
  c06x36c: undefined,
  c07x36n: undefined,
  c08x36c: undefined,
  c06x37c: undefined,
  c07x37n: undefined,
  c08x37c: undefined,
  c06x38c: undefined,
  c07x38n: undefined,
  c08x38c: undefined,
  c06x39c: undefined,
  c07x39n: undefined,
  c08x39c: undefined,
  c06x40c: undefined,
  c07x40n: undefined,
  c08x40c: undefined,
  c09c: undefined,
  c10n: undefined,
  c11: undefined,
  c12c: undefined,
  c13n: undefined,
  c24c: undefined,
  c25: undefined,
  c26c: undefined,
  c27c: undefined,
  c34c: undefined,
  b22: undefined,
  b23: undefined,
  b24: undefined,
  b25: undefined,
  b26: undefined,
  b27: undefined,
  b28: undefined,
  b29: undefined,
  b30c: undefined,
  b31: undefined,
  b32: undefined,
  b33: undefined,
  c14x01c: undefined,
  c15x01n: undefined,
  c16x01: undefined,
  c17x01: undefined,
  c18x01: undefined,
  c19x01: undefined,
  c20x01: undefined,
  c21x01c: undefined,
  c22x01c: undefined,
  c23x01: undefined,
  a16: undefined,
  a18x01: undefined,
  a18x02: undefined,
  a18x03: undefined,
  a18x04: undefined,
  a18x05: undefined,
  a17: undefined,
  c28: undefined,
  c29: undefined,
  c30: undefined,
  c31: undefined,
  c32: undefined,
  c33: undefined,
  b36c: undefined,
  b37: undefined,
  b34c: undefined,
  b35: undefined,
  c14x02c: undefined,
  c15x02n: undefined,
  c16x02: undefined,
  c17x02: undefined,
  c18x02: undefined,
  c19x02: undefined,
  c20x02: undefined,
  c21x02c: undefined,
  c22x02c: undefined,
  c23x02: undefined,
  c14x03c: undefined,
  c15x03n: undefined,
  c16x03: undefined,
  c17x03: undefined,
  c18x03: undefined,
  c19x03: undefined,
  c20x03: undefined,
  c21x03c: undefined,
  c22x03c: undefined,
  c23x03: undefined,
  c14x04c: undefined,
  c15x04n: undefined,
  c16x04: undefined,
  c17x04: undefined,
  c18x04: undefined,
  c19x04: undefined,
  c20x04: undefined,
  c21x04c: undefined,
  c22x04c: undefined,
  c23x04: undefined,
  c14x05c: undefined,
  c15x05n: undefined,
  c16x05: undefined,
  c17x05: undefined,
  c18x05: undefined,
  c19x05: undefined,
  c20x05: undefined,
  c21x05c: undefined,
  c22x05c: undefined,
  c23x05: undefined,
  c14x06c: undefined,
  c15x06n: undefined,
  c16x06: undefined,
  c17x06: undefined,
  c18x06: undefined,
  c19x06: undefined,
  c20x06: undefined,
  c21x06c: undefined,
  c22x06c: undefined,
  c23x06: undefined,
  c14x07c: undefined,
  c15x07n: undefined,
  c16x07: undefined,
  c17x07: undefined,
  c18x07: undefined,
  c19x07: undefined,
  c20x07: undefined,
  c21x07c: undefined,
  c22x07c: undefined,
  c23x07: undefined,
  c14x08c: undefined,
  c15x08n: undefined,
  c16x08: undefined,
  c17x08: undefined,
  c18x08: undefined,
  c19x08: undefined,
  c20x08: undefined,
  c21x08c: undefined,
  c22x08c: undefined,
  c23x08: undefined,
  c14x09c: undefined,
  c15x09n: undefined,
  c16x09: undefined,
  c17x09: undefined,
  c18x09: undefined,
  c19x09: undefined,
  c20x09: undefined,
  c21x09c: undefined,
  c22x09c: undefined,
  c23x09: undefined,
  c14x10c: undefined,
  c15x10n: undefined,
  c16x10: undefined,
  c17x10: undefined,
  c18x10: undefined,
  c19x10: undefined,
  c20x10: undefined,
  c21x10c: undefined,
  c22x10c: undefined,
  c23x10: undefined
}
const data = reactive<PageData<NatdssB04MedicalRecordFrontSheetNonTcmForm, NatdssB04MedicalRecordFrontSheetNonTcmQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    a01: undefined,
    a02: undefined,
    a48: undefined,
    a49: undefined,
    b12: undefined,
    b15: undefined,
    a47: undefined,
    a46c: undefined,
    a11: undefined,
    a12c: undefined,
    a13: undefined,
    a14: undefined,
    a15c: undefined,
    a21c: undefined,
    a38c: undefined,
    a19c: undefined,
    a20: undefined,
    a22: undefined,
    a23c: undefined,
    a24: undefined,
    a25c: undefined,
    a26: undefined,
    a27: undefined,
    a28c: undefined,
    a29: undefined,
    a30: undefined,
    a31c: undefined,
    a32: undefined,
    a33c: undefined,
    a34: undefined,
    a35: undefined,
    b11c: undefined,
    b13c: undefined,
    b14: undefined,
    b21c: undefined,
    b16c: undefined,
    b17: undefined,
    b20: undefined,
    c01c: undefined,
    c02n: undefined,
    c03c: undefined,
    c04n: undefined,
    c05c: undefined,
    c06x01c: undefined,
    c07x01n: undefined,
    c08x01c: undefined,
    c06x02c: undefined,
    c07x02n: undefined,
    c08x02c: undefined,
    c06x03c: undefined,
    c07x03n: undefined,
    c08x03c: undefined,
    c06x04c: undefined,
    c07x04n: undefined,
    c08x04c: undefined,
    c06x05c: undefined,
    c07x05n: undefined,
    c08x05c: undefined,
    c06x06c: undefined,
    c07x06n: undefined,
    c08x06c: undefined,
    c06x07c: undefined,
    c07x07n: undefined,
    c08x07c: undefined,
    c06x08c: undefined,
    c07x08n: undefined,
    c08x08c: undefined,
    c06x09c: undefined,
    c07x09n: undefined,
    c08x09c: undefined,
    c06x10c: undefined,
    c07x10n: undefined,
    c08x10c: undefined,
    c06x11c: undefined,
    c07x11n: undefined,
    c08x11c: undefined,
    c06x12c: undefined,
    c07x12n: undefined,
    c08x12c: undefined,
    c06x13c: undefined,
    c07x13n: undefined,
    c08x13c: undefined,
    c06x14c: undefined,
    c07x14n: undefined,
    c08x14c: undefined,
    c06x15c: undefined,
    c07x15n: undefined,
    c08x15c: undefined,
    c06x16c: undefined,
    c07x16n: undefined,
    c08x16c: undefined,
    c06x17c: undefined,
    c07x17n: undefined,
    c08x17c: undefined,
    c06x18c: undefined,
    c07x18n: undefined,
    c08x18c: undefined,
    c06x19c: undefined,
    c07x19n: undefined,
    c08x19c: undefined,
    c06x20c: undefined,
    c07x20n: undefined,
    c08x20c: undefined,
    c06x21c: undefined,
    c07x21n: undefined,
    c08x21c: undefined,
    c06x22c: undefined,
    c07x22n: undefined,
    c08x22c: undefined,
    c06x23c: undefined,
    c07x23n: undefined,
    c08x23c: undefined,
    c06x24c: undefined,
    c07x24n: undefined,
    c08x24c: undefined,
    c06x25c: undefined,
    c07x25n: undefined,
    c08x25c: undefined,
    c06x26c: undefined,
    c07x26n: undefined,
    c08x26c: undefined,
    c06x27c: undefined,
    c07x27n: undefined,
    c08x27c: undefined,
    c06x28c: undefined,
    c07x28n: undefined,
    c08x28c: undefined,
    c06x29c: undefined,
    c07x29n: undefined,
    c08x29c: undefined,
    c06x30c: undefined,
    c07x30n: undefined,
    c08x30c: undefined,
    c06x31c: undefined,
    c07x31n: undefined,
    c08x31c: undefined,
    c06x32c: undefined,
    c07x32n: undefined,
    c08x32c: undefined,
    c06x33c: undefined,
    c07x33n: undefined,
    c08x33c: undefined,
    c06x34c: undefined,
    c07x34n: undefined,
    c08x34c: undefined,
    c06x35c: undefined,
    c07x35n: undefined,
    c08x35c: undefined,
    c06x36c: undefined,
    c07x36n: undefined,
    c08x36c: undefined,
    c06x37c: undefined,
    c07x37n: undefined,
    c08x37c: undefined,
    c06x38c: undefined,
    c07x38n: undefined,
    c08x38c: undefined,
    c06x39c: undefined,
    c07x39n: undefined,
    c08x39c: undefined,
    c06x40c: undefined,
    c07x40n: undefined,
    c08x40c: undefined,
    c09c: undefined,
    c10n: undefined,
    c11: undefined,
    c12c: undefined,
    c13n: undefined,
    c24c: undefined,
    c25: undefined,
    c26c: undefined,
    c27c: undefined,
    c34c: undefined,
    b22: undefined,
    b23: undefined,
    b24: undefined,
    b25: undefined,
    b26: undefined,
    b27: undefined,
    b28: undefined,
    b29: undefined,
    b30c: undefined,
    b31: undefined,
    b32: undefined,
    b33: undefined,
    c14x01c: undefined,
    c15x01n: undefined,
    c16x01: undefined,
    c17x01: undefined,
    c18x01: undefined,
    c19x01: undefined,
    c20x01: undefined,
    c21x01c: undefined,
    c22x01c: undefined,
    c23x01: undefined,
    a16: undefined,
    a18x01: undefined,
    a18x02: undefined,
    a18x03: undefined,
    a18x04: undefined,
    a18x05: undefined,
    a17: undefined,
    c28: undefined,
    c29: undefined,
    c30: undefined,
    c31: undefined,
    c32: undefined,
    c33: undefined,
    b36c: undefined,
    b37: undefined,
    b34c: undefined,
    b35: undefined,
    c14x02c: undefined,
    c15x02n: undefined,
    c16x02: undefined,
    c17x02: undefined,
    c18x02: undefined,
    c19x02: undefined,
    c20x02: undefined,
    c21x02c: undefined,
    c22x02c: undefined,
    c23x02: undefined,
    c14x03c: undefined,
    c15x03n: undefined,
    c16x03: undefined,
    c17x03: undefined,
    c18x03: undefined,
    c19x03: undefined,
    c20x03: undefined,
    c21x03c: undefined,
    c22x03c: undefined,
    c23x03: undefined,
    c14x04c: undefined,
    c15x04n: undefined,
    c16x04: undefined,
    c17x04: undefined,
    c18x04: undefined,
    c19x04: undefined,
    c20x04: undefined,
    c21x04c: undefined,
    c22x04c: undefined,
    c23x04: undefined,
    c14x05c: undefined,
    c15x05n: undefined,
    c16x05: undefined,
    c17x05: undefined,
    c18x05: undefined,
    c19x05: undefined,
    c20x05: undefined,
    c21x05c: undefined,
    c22x05c: undefined,
    c23x05: undefined,
    c14x06c: undefined,
    c15x06n: undefined,
    c16x06: undefined,
    c17x06: undefined,
    c18x06: undefined,
    c19x06: undefined,
    c20x06: undefined,
    c21x06c: undefined,
    c22x06c: undefined,
    c23x06: undefined,
    c14x07c: undefined,
    c15x07n: undefined,
    c16x07: undefined,
    c17x07: undefined,
    c18x07: undefined,
    c19x07: undefined,
    c20x07: undefined,
    c21x07c: undefined,
    c22x07c: undefined,
    c23x07: undefined,
    c14x08c: undefined,
    c15x08n: undefined,
    c16x08: undefined,
    c17x08: undefined,
    c18x08: undefined,
    c19x08: undefined,
    c20x08: undefined,
    c21x08c: undefined,
    c22x08c: undefined,
    c23x08: undefined,
    c14x09c: undefined,
    c15x09n: undefined,
    c16x09: undefined,
    c17x09: undefined,
    c18x09: undefined,
    c19x09: undefined,
    c20x09: undefined,
    c21x09c: undefined,
    c22x09c: undefined,
    c23x09: undefined,
    c14x10c: undefined,
    c15x10n: undefined,
    c16x10: undefined,
    c17x10: undefined,
    c18x10: undefined,
    c19x10: undefined,
    c20x10: undefined,
    c21x10c: undefined,
    c22x10c: undefined,
    c23x10: undefined,
    params: {
    }
  },
  rules: {
    patientId: [
      { required: true, message: "患者ID不能为空", trigger: "blur" }
    ],
    visitSn: [
      { required: true, message: "单次就诊唯一标识号不能为空", trigger: "blur" }
    ],
    a01: [
      { required: true, message: "组织机构代码不能为空", trigger: "blur" }
    ],
    a02: [
      { required: true, message: "医疗机构名称不能为空", trigger: "blur" }
    ],
    a48: [
      { required: true, message: "病案号不能为空", trigger: "blur" }
    ],
    a49: [
      { required: true, message: "住院次数不能为空", trigger: "blur" }
    ],
    b12: [
      { required: true, message: "入院时间不能为空", trigger: "blur" }
    ],
    b15: [
      { required: true, message: "出院时间不能为空", trigger: "blur" }
    ],
    a47: [
      { required: true, message: "健康卡号不能为空", trigger: "blur" }
    ],
    a46c: [
      { required: true, message: "医疗付费方式不能为空", trigger: "blur" }
    ],
    a11: [
      { required: true, message: "姓名不能为空", trigger: "blur" }
    ],
    a12c: [
      { required: true, message: "性别不能为空", trigger: "blur" }
    ],
    a13: [
      { required: true, message: "出生日期不能为空", trigger: "blur" }
    ],
    a14: [
      { required: true, message: "年龄(岁)不能为空", trigger: "blur" }
    ],
    a15c: [
      { required: true, message: "国籍不能为空", trigger: "blur" }
    ],
    a21c: [
      { required: true, message: "婚姻不能为空", trigger: "blur" }
    ],
    a38c: [
      { required: true, message: "职业不能为空", trigger: "blur" }
    ],
    a19c: [
      { required: true, message: "民族不能为空", trigger: "blur" }
    ],
    a20: [
      { required: true, message: "身份证号不能为空", trigger: "blur" }
    ],
    a22: [
      { required: true, message: "出生地址不能为空", trigger: "blur" }
    ],
    a23c: [
      { required: true, message: "籍贯省(自治区、直辖市)不能为空", trigger: "blur" }
    ],
    a24: [
      { required: true, message: "户口地址不能为空", trigger: "blur" }
    ],
    a25c: [
      { required: true, message: "户口地址邮政编码不能为空", trigger: "blur" }
    ],
    a26: [
      { required: true, message: "现住址不能为空", trigger: "blur" }
    ],
    a27: [
      { required: true, message: "现住址电话不能为空", trigger: "blur" }
    ],
    a28c: [
      { required: true, message: "现住址邮政编码不能为空", trigger: "blur" }
    ],
    a29: [
      { required: true, message: "工作单位及地址不能为空", trigger: "blur" }
    ],
    a30: [
      { required: true, message: "工作单位电话不能为空", trigger: "blur" }
    ],
    a31c: [
      { required: true, message: "工作单位邮政编码不能为空", trigger: "blur" }
    ],
    a32: [
      { required: true, message: "联系人姓名不能为空", trigger: "blur" }
    ],
    a33c: [
      { required: true, message: "联系人关系不能为空", trigger: "blur" }
    ],
    a34: [
      { required: true, message: "联系人地址不能为空", trigger: "blur" }
    ],
    a35: [
      { required: true, message: "联系人电话不能为空", trigger: "blur" }
    ],
    b11c: [
      { required: true, message: "入院途径不能为空", trigger: "blur" }
    ],
    b13c: [
      { required: true, message: "入院科别不能为空", trigger: "blur" }
    ],
    b14: [
      { required: true, message: "入院病房不能为空", trigger: "blur" }
    ],
    b21c: [
      { required: true, message: "转科科别不能为空", trigger: "blur" }
    ],
    b16c: [
      { required: true, message: "出院科别不能为空", trigger: "blur" }
    ],
    b17: [
      { required: true, message: "出院病房不能为空", trigger: "blur" }
    ],
    b20: [
      { required: true, message: "实际住院(天)不能为空", trigger: "blur" }
    ],
    c01c: [
      { required: true, message: "门(急)诊诊断编码不能为空", trigger: "blur" }
    ],
    c02n: [
      { required: true, message: "门(急)诊诊断名称不能为空", trigger: "blur" }
    ],
    c03c: [
      { required: true, message: "出院主要诊断编码不能为空", trigger: "blur" }
    ],
    c04n: [
      { required: true, message: "出院主要诊断名称不能为空", trigger: "blur" }
    ],
    c05c: [
      { required: true, message: "出院主要诊断入院病情不能为空", trigger: "blur" }
    ],
    c24c: [
      { required: true, message: "有无药物过敏不能为空", trigger: "blur" }
    ],
    c26c: [
      { required: true, message: "ABO血型不能为空", trigger: "blur" }
    ],
    c27c: [
      { required: true, message: "Rh血型不能为空", trigger: "blur" }
    ],
    c34c: [
      { required: true, message: "死亡患者尸检不能为空", trigger: "blur" }
    ],
    b22: [
      { required: true, message: "科主任不能为空", trigger: "blur" }
    ],
    b23: [
      { required: true, message: "主(副主)任医师不能为空", trigger: "blur" }
    ],
    b24: [
      { required: true, message: "主治医师不能为空", trigger: "blur" }
    ],
    b25: [
      { required: true, message: "住院医师不能为空", trigger: "blur" }
    ],
    b26: [
      { required: true, message: "责任护士不能为空", trigger: "blur" }
    ],
    b27: [
      { required: true, message: "进修医师不能为空", trigger: "blur" }
    ],
    b28: [
      { required: true, message: "实习医师不能为空", trigger: "blur" }
    ],
    b29: [
      { required: true, message: "编码员不能为空", trigger: "blur" }
    ],
    b30c: [
      { required: true, message: "病案质量不能为空", trigger: "blur" }
    ],
    b31: [
      { required: true, message: "质控医师不能为空", trigger: "blur" }
    ],
    b32: [
      { required: true, message: "质控护师不能为空", trigger: "blur" }
    ],
    b33: [
      { required: true, message: "质控日期不能为空", trigger: "blur" }
    ],
    b36c: [
      { required: true, message: "是否有出院31日内再住院计划不能为空", trigger: "blur" }
    ],
    b34c: [
      { required: true, message: "离院方式不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询B04病历首页-核心信息-非中医院（基础+诊断+主要手术）列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNatdssB04MedicalRecordFrontSheetNonTcm(queryParams.value);
  natdssB04MedicalRecordFrontSheetNonTcmList.value = res.rows;
  total.value = res.total;
  loading.value = false;
}

/** 取消按钮 */
const cancel = () => {
  reset();
  dialog.visible = false;
}

/** 表单重置 */
const reset = () => {
  form.value = {...initFormData};
  natdssB04MedicalRecordFrontSheetNonTcmFormRef.value?.resetFields();
}

/** 搜索按钮操作 */
const handleQuery = () => {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
const resetQuery = () => {
  queryFormRef.value?.resetFields();
  handleQuery();
}

/** 多选框选中数据 */
const handleSelectionChange = (selection: NatdssB04MedicalRecordFrontSheetNonTcmVO[]) => {
  ids.value = selection.map(item => item.patientId);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加B04病历首页-核心信息-非中医院（基础+诊断+主要手术）";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NatdssB04MedicalRecordFrontSheetNonTcmVO) => {
  reset();
  const _patientId = row?.patientId || ids.value[0]
  const res = await getNatdssB04MedicalRecordFrontSheetNonTcm(_patientId);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改B04病历首页-核心信息-非中医院（基础+诊断+主要手术）";
}

/** 提交按钮 */
const submitForm = () => {
  natdssB04MedicalRecordFrontSheetNonTcmFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.patientId) {
        await updateNatdssB04MedicalRecordFrontSheetNonTcm(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNatdssB04MedicalRecordFrontSheetNonTcm(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NatdssB04MedicalRecordFrontSheetNonTcmVO) => {
  const _patientIds = row?.patientId || ids.value;
  await proxy?.$modal.confirm('是否确认删除B04病历首页-核心信息-非中医院（基础+诊断+主要手术）编号为"' + _patientIds + '"的数据项？').finally(() => loading.value = false);
  await delNatdssB04MedicalRecordFrontSheetNonTcm(_patientIds);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('natdss/natdssB04MedicalRecordFrontSheetNonTcm/export', {
    ...queryParams.value
  }, `natdssB04MedicalRecordFrontSheetNonTcm_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
