<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="其他手术操作编码1" prop="c35x01c">
              <el-input v-model="queryParams.c35x01c" placeholder="请输入其他手术操作编码1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称1" prop="c36x01n">
              <el-input v-model="queryParams.c36x01n" placeholder="请输入其他手术操作名称1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期1" prop="c37x01">
              <el-date-picker clearable
                v-model="queryParams.c37x01"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期1"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别1" prop="c38x01">
              <el-input v-model="queryParams.c38x01" placeholder="请输入其他手术操作级别1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者1" prop="c39x01">
              <el-input v-model="queryParams.c39x01" placeholder="请输入其他手术操作术者1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助1" prop="c40x01">
              <el-input v-model="queryParams.c40x01" placeholder="请输入其他手术操作Ⅰ助1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助1" prop="c41x01">
              <el-input v-model="queryParams.c41x01" placeholder="请输入其他手术操作Ⅱ助1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级1" prop="c42x01c">
              <el-input v-model="queryParams.c42x01c" placeholder="请输入其他手术操作切口愈合等级1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式1" prop="c43x01c">
              <el-input v-model="queryParams.c43x01c" placeholder="请输入其他手术操作麻醉方式1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师1" prop="c44x01">
              <el-input v-model="queryParams.c44x01" placeholder="请输入其他手术操作麻醉医师1" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码2" prop="c35x02c">
              <el-input v-model="queryParams.c35x02c" placeholder="请输入其他手术操作编码2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称2" prop="c36x02n">
              <el-input v-model="queryParams.c36x02n" placeholder="请输入其他手术操作名称2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期2" prop="c37x02">
              <el-date-picker clearable
                v-model="queryParams.c37x02"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期2"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别2" prop="c38x02">
              <el-input v-model="queryParams.c38x02" placeholder="请输入其他手术操作级别2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者2" prop="c39x02">
              <el-input v-model="queryParams.c39x02" placeholder="请输入其他手术操作术者2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助2" prop="c40x02">
              <el-input v-model="queryParams.c40x02" placeholder="请输入其他手术操作Ⅰ助2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助2" prop="c41x02">
              <el-input v-model="queryParams.c41x02" placeholder="请输入其他手术操作Ⅱ助2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级2" prop="c42x02c">
              <el-input v-model="queryParams.c42x02c" placeholder="请输入其他手术操作切口愈合等级2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式2" prop="c43x02c">
              <el-input v-model="queryParams.c43x02c" placeholder="请输入其他手术操作麻醉方式2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师2" prop="c44x02">
              <el-input v-model="queryParams.c44x02" placeholder="请输入其他手术操作麻醉医师2" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码3" prop="c35x03c">
              <el-input v-model="queryParams.c35x03c" placeholder="请输入其他手术操作编码3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称3" prop="c36x03n">
              <el-input v-model="queryParams.c36x03n" placeholder="请输入其他手术操作名称3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期3" prop="c37x03">
              <el-date-picker clearable
                v-model="queryParams.c37x03"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期3"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别3" prop="c38x03">
              <el-input v-model="queryParams.c38x03" placeholder="请输入其他手术操作级别3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者3" prop="c39x03">
              <el-input v-model="queryParams.c39x03" placeholder="请输入其他手术操作术者3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助3" prop="c40x03">
              <el-input v-model="queryParams.c40x03" placeholder="请输入其他手术操作Ⅰ助3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助3" prop="c41x03">
              <el-input v-model="queryParams.c41x03" placeholder="请输入其他手术操作Ⅱ助3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级3" prop="c42x03c">
              <el-input v-model="queryParams.c42x03c" placeholder="请输入其他手术操作切口愈合等级3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式3" prop="c43x03c">
              <el-input v-model="queryParams.c43x03c" placeholder="请输入其他手术操作麻醉方式3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师3" prop="c44x03">
              <el-input v-model="queryParams.c44x03" placeholder="请输入其他手术操作麻醉医师3" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码4" prop="c35x04c">
              <el-input v-model="queryParams.c35x04c" placeholder="请输入其他手术操作编码4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称4" prop="c36x04n">
              <el-input v-model="queryParams.c36x04n" placeholder="请输入其他手术操作名称4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期4" prop="c37x04">
              <el-date-picker clearable
                v-model="queryParams.c37x04"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期4"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别4" prop="c38x04">
              <el-input v-model="queryParams.c38x04" placeholder="请输入其他手术操作级别4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者4" prop="c39x04">
              <el-input v-model="queryParams.c39x04" placeholder="请输入其他手术操作术者4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助4" prop="c40x04">
              <el-input v-model="queryParams.c40x04" placeholder="请输入其他手术操作Ⅰ助4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助4" prop="c41x04">
              <el-input v-model="queryParams.c41x04" placeholder="请输入其他手术操作Ⅱ助4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级4" prop="c42x04c">
              <el-input v-model="queryParams.c42x04c" placeholder="请输入其他手术操作切口愈合等级4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式4" prop="c43x04c">
              <el-input v-model="queryParams.c43x04c" placeholder="请输入其他手术操作麻醉方式4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师4" prop="c44x04">
              <el-input v-model="queryParams.c44x04" placeholder="请输入其他手术操作麻醉医师4" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码5" prop="c35x05c">
              <el-input v-model="queryParams.c35x05c" placeholder="请输入其他手术操作编码5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称5" prop="c36x05n">
              <el-input v-model="queryParams.c36x05n" placeholder="请输入其他手术操作名称5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期5" prop="c37x05">
              <el-date-picker clearable
                v-model="queryParams.c37x05"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期5"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别5" prop="c38x05">
              <el-input v-model="queryParams.c38x05" placeholder="请输入其他手术操作级别5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者5" prop="c39x05">
              <el-input v-model="queryParams.c39x05" placeholder="请输入其他手术操作术者5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助5" prop="c40x05">
              <el-input v-model="queryParams.c40x05" placeholder="请输入其他手术操作Ⅰ助5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助5" prop="c41x05">
              <el-input v-model="queryParams.c41x05" placeholder="请输入其他手术操作Ⅱ助5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级5" prop="c42x05c">
              <el-input v-model="queryParams.c42x05c" placeholder="请输入其他手术操作切口愈合等级5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式5" prop="c43x05c">
              <el-input v-model="queryParams.c43x05c" placeholder="请输入其他手术操作麻醉方式5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师5" prop="c44x05">
              <el-input v-model="queryParams.c44x05" placeholder="请输入其他手术操作麻醉医师5" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码6" prop="c35x06c">
              <el-input v-model="queryParams.c35x06c" placeholder="请输入其他手术操作编码6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称6" prop="c36x06n">
              <el-input v-model="queryParams.c36x06n" placeholder="请输入其他手术操作名称6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期6" prop="c37x06">
              <el-date-picker clearable
                v-model="queryParams.c37x06"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期6"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别6" prop="c38x06">
              <el-input v-model="queryParams.c38x06" placeholder="请输入其他手术操作级别6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者6" prop="c39x06">
              <el-input v-model="queryParams.c39x06" placeholder="请输入其他手术操作术者6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助6" prop="c40x06">
              <el-input v-model="queryParams.c40x06" placeholder="请输入其他手术操作Ⅰ助6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助6" prop="c41x06">
              <el-input v-model="queryParams.c41x06" placeholder="请输入其他手术操作Ⅱ助6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级6" prop="c42x06c">
              <el-input v-model="queryParams.c42x06c" placeholder="请输入其他手术操作切口愈合等级6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式6" prop="c43x06c">
              <el-input v-model="queryParams.c43x06c" placeholder="请输入其他手术操作麻醉方式6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师6" prop="c44x06">
              <el-input v-model="queryParams.c44x06" placeholder="请输入其他手术操作麻醉医师6" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码7" prop="c35x07c">
              <el-input v-model="queryParams.c35x07c" placeholder="请输入其他手术操作编码7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称7" prop="c36x07n">
              <el-input v-model="queryParams.c36x07n" placeholder="请输入其他手术操作名称7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期7" prop="c37x07">
              <el-date-picker clearable
                v-model="queryParams.c37x07"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期7"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别7" prop="c38x07">
              <el-input v-model="queryParams.c38x07" placeholder="请输入其他手术操作级别7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者7" prop="c39x07">
              <el-input v-model="queryParams.c39x07" placeholder="请输入其他手术操作术者7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助7" prop="c40x07">
              <el-input v-model="queryParams.c40x07" placeholder="请输入其他手术操作Ⅰ助7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助7" prop="c41x07">
              <el-input v-model="queryParams.c41x07" placeholder="请输入其他手术操作Ⅱ助7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级7" prop="c42x07c">
              <el-input v-model="queryParams.c42x07c" placeholder="请输入其他手术操作切口愈合等级7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式7" prop="c43x07c">
              <el-input v-model="queryParams.c43x07c" placeholder="请输入其他手术操作麻醉方式7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师7" prop="c44x07">
              <el-input v-model="queryParams.c44x07" placeholder="请输入其他手术操作麻醉医师7" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码8" prop="c35x08c">
              <el-input v-model="queryParams.c35x08c" placeholder="请输入其他手术操作编码8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称8" prop="c36x08n">
              <el-input v-model="queryParams.c36x08n" placeholder="请输入其他手术操作名称8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期8" prop="c37x08">
              <el-date-picker clearable
                v-model="queryParams.c37x08"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期8"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别8" prop="c38x08">
              <el-input v-model="queryParams.c38x08" placeholder="请输入其他手术操作级别8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者8" prop="c39x08">
              <el-input v-model="queryParams.c39x08" placeholder="请输入其他手术操作术者8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助8" prop="c40x08">
              <el-input v-model="queryParams.c40x08" placeholder="请输入其他手术操作Ⅰ助8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助8" prop="c41x08">
              <el-input v-model="queryParams.c41x08" placeholder="请输入其他手术操作Ⅱ助8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级8" prop="c42x08c">
              <el-input v-model="queryParams.c42x08c" placeholder="请输入其他手术操作切口愈合等级8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式8" prop="c43x08c">
              <el-input v-model="queryParams.c43x08c" placeholder="请输入其他手术操作麻醉方式8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师8" prop="c44x08">
              <el-input v-model="queryParams.c44x08" placeholder="请输入其他手术操作麻醉医师8" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码9" prop="c35x09c">
              <el-input v-model="queryParams.c35x09c" placeholder="请输入其他手术操作编码9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称9" prop="c36x09n">
              <el-input v-model="queryParams.c36x09n" placeholder="请输入其他手术操作名称9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期9" prop="c37x09">
              <el-date-picker clearable
                v-model="queryParams.c37x09"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期9"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别9" prop="c38x09">
              <el-input v-model="queryParams.c38x09" placeholder="请输入其他手术操作级别9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者9" prop="c39x09">
              <el-input v-model="queryParams.c39x09" placeholder="请输入其他手术操作术者9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助9" prop="c40x09">
              <el-input v-model="queryParams.c40x09" placeholder="请输入其他手术操作Ⅰ助9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助9" prop="c41x09">
              <el-input v-model="queryParams.c41x09" placeholder="请输入其他手术操作Ⅱ助9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级9" prop="c42x09c">
              <el-input v-model="queryParams.c42x09c" placeholder="请输入其他手术操作切口愈合等级9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式9" prop="c43x09c">
              <el-input v-model="queryParams.c43x09c" placeholder="请输入其他手术操作麻醉方式9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师9" prop="c44x09">
              <el-input v-model="queryParams.c44x09" placeholder="请输入其他手术操作麻醉医师9" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码10" prop="c35x10c">
              <el-input v-model="queryParams.c35x10c" placeholder="请输入其他手术操作编码10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称10" prop="c36x10n">
              <el-input v-model="queryParams.c36x10n" placeholder="请输入其他手术操作名称10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期10" prop="c37x10">
              <el-date-picker clearable
                v-model="queryParams.c37x10"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期10"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别10" prop="c38x10">
              <el-input v-model="queryParams.c38x10" placeholder="请输入其他手术操作级别10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者10" prop="c39x10">
              <el-input v-model="queryParams.c39x10" placeholder="请输入其他手术操作术者10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助10" prop="c40x10">
              <el-input v-model="queryParams.c40x10" placeholder="请输入其他手术操作Ⅰ助10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助10" prop="c41x10">
              <el-input v-model="queryParams.c41x10" placeholder="请输入其他手术操作Ⅱ助10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级10" prop="c42x10c">
              <el-input v-model="queryParams.c42x10c" placeholder="请输入其他手术操作切口愈合等级10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式10" prop="c43x10c">
              <el-input v-model="queryParams.c43x10c" placeholder="请输入其他手术操作麻醉方式10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师10" prop="c44x10">
              <el-input v-model="queryParams.c44x10" placeholder="请输入其他手术操作麻醉医师10" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码11" prop="c35x11c">
              <el-input v-model="queryParams.c35x11c" placeholder="请输入其他手术操作编码11" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称11" prop="c36x11n">
              <el-input v-model="queryParams.c36x11n" placeholder="请输入其他手术操作名称11" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期11" prop="c37x11">
              <el-date-picker clearable
                v-model="queryParams.c37x11"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期11"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别11" prop="c38x11">
              <el-input v-model="queryParams.c38x11" placeholder="请输入其他手术操作级别11" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者11" prop="c39x11">
              <el-input v-model="queryParams.c39x11" placeholder="请输入其他手术操作术者11" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助11" prop="c40x11">
              <el-input v-model="queryParams.c40x11" placeholder="请输入其他手术操作Ⅰ助11" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助11" prop="c41x11">
              <el-input v-model="queryParams.c41x11" placeholder="请输入其他手术操作Ⅱ助11" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级11" prop="c42x11c">
              <el-input v-model="queryParams.c42x11c" placeholder="请输入其他手术操作切口愈合等级11" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式11" prop="c43x11c">
              <el-input v-model="queryParams.c43x11c" placeholder="请输入其他手术操作麻醉方式11" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师11" prop="c44x11">
              <el-input v-model="queryParams.c44x11" placeholder="请输入其他手术操作麻醉医师11" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码12" prop="c35x12c">
              <el-input v-model="queryParams.c35x12c" placeholder="请输入其他手术操作编码12" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称12" prop="c36x12n">
              <el-input v-model="queryParams.c36x12n" placeholder="请输入其他手术操作名称12" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期12" prop="c37x12">
              <el-date-picker clearable
                v-model="queryParams.c37x12"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期12"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别12" prop="c38x12">
              <el-input v-model="queryParams.c38x12" placeholder="请输入其他手术操作级别12" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者12" prop="c39x12">
              <el-input v-model="queryParams.c39x12" placeholder="请输入其他手术操作术者12" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助12" prop="c40x12">
              <el-input v-model="queryParams.c40x12" placeholder="请输入其他手术操作Ⅰ助12" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助12" prop="c41x12">
              <el-input v-model="queryParams.c41x12" placeholder="请输入其他手术操作Ⅱ助12" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级12" prop="c42x12c">
              <el-input v-model="queryParams.c42x12c" placeholder="请输入其他手术操作切口愈合等级12" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式12" prop="c43x12c">
              <el-input v-model="queryParams.c43x12c" placeholder="请输入其他手术操作麻醉方式12" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师12" prop="c44x12">
              <el-input v-model="queryParams.c44x12" placeholder="请输入其他手术操作麻醉医师12" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码13" prop="c35x13c">
              <el-input v-model="queryParams.c35x13c" placeholder="请输入其他手术操作编码13" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称13" prop="c36x13n">
              <el-input v-model="queryParams.c36x13n" placeholder="请输入其他手术操作名称13" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期13" prop="c37x13">
              <el-date-picker clearable
                v-model="queryParams.c37x13"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期13"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别13" prop="c38x13">
              <el-input v-model="queryParams.c38x13" placeholder="请输入其他手术操作级别13" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者13" prop="c39x13">
              <el-input v-model="queryParams.c39x13" placeholder="请输入其他手术操作术者13" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助13" prop="c40x13">
              <el-input v-model="queryParams.c40x13" placeholder="请输入其他手术操作Ⅰ助13" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助13" prop="c41x13">
              <el-input v-model="queryParams.c41x13" placeholder="请输入其他手术操作Ⅱ助13" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级13" prop="c42x13c">
              <el-input v-model="queryParams.c42x13c" placeholder="请输入其他手术操作切口愈合等级13" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式13" prop="c43x13c">
              <el-input v-model="queryParams.c43x13c" placeholder="请输入其他手术操作麻醉方式13" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师13" prop="c44x13">
              <el-input v-model="queryParams.c44x13" placeholder="请输入其他手术操作麻醉医师13" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码14" prop="c35x14c">
              <el-input v-model="queryParams.c35x14c" placeholder="请输入其他手术操作编码14" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称14" prop="c36x14n">
              <el-input v-model="queryParams.c36x14n" placeholder="请输入其他手术操作名称14" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期14" prop="c37x14">
              <el-date-picker clearable
                v-model="queryParams.c37x14"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期14"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别14" prop="c38x14">
              <el-input v-model="queryParams.c38x14" placeholder="请输入其他手术操作级别14" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者14" prop="c39x14">
              <el-input v-model="queryParams.c39x14" placeholder="请输入其他手术操作术者14" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助14" prop="c40x14">
              <el-input v-model="queryParams.c40x14" placeholder="请输入其他手术操作Ⅰ助14" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助14" prop="c41x14">
              <el-input v-model="queryParams.c41x14" placeholder="请输入其他手术操作Ⅱ助14" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级14" prop="c42x14c">
              <el-input v-model="queryParams.c42x14c" placeholder="请输入其他手术操作切口愈合等级14" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式14" prop="c43x14c">
              <el-input v-model="queryParams.c43x14c" placeholder="请输入其他手术操作麻醉方式14" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师14" prop="c44x14">
              <el-input v-model="queryParams.c44x14" placeholder="请输入其他手术操作麻醉医师14" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码15" prop="c35x15c">
              <el-input v-model="queryParams.c35x15c" placeholder="请输入其他手术操作编码15" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称15" prop="c36x15n">
              <el-input v-model="queryParams.c36x15n" placeholder="请输入其他手术操作名称15" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期15" prop="c37x15">
              <el-date-picker clearable
                v-model="queryParams.c37x15"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期15"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别15" prop="c38x15">
              <el-input v-model="queryParams.c38x15" placeholder="请输入其他手术操作级别15" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者15" prop="c39x15">
              <el-input v-model="queryParams.c39x15" placeholder="请输入其他手术操作术者15" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助15" prop="c40x15">
              <el-input v-model="queryParams.c40x15" placeholder="请输入其他手术操作Ⅰ助15" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助15" prop="c41x15">
              <el-input v-model="queryParams.c41x15" placeholder="请输入其他手术操作Ⅱ助15" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级15" prop="c42x15c">
              <el-input v-model="queryParams.c42x15c" placeholder="请输入其他手术操作切口愈合等级15" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式15" prop="c43x15c">
              <el-input v-model="queryParams.c43x15c" placeholder="请输入其他手术操作麻醉方式15" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师15" prop="c44x15">
              <el-input v-model="queryParams.c44x15" placeholder="请输入其他手术操作麻醉医师15" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码16" prop="c35x16c">
              <el-input v-model="queryParams.c35x16c" placeholder="请输入其他手术操作编码16" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称16" prop="c36x16n">
              <el-input v-model="queryParams.c36x16n" placeholder="请输入其他手术操作名称16" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期16" prop="c37x16">
              <el-date-picker clearable
                v-model="queryParams.c37x16"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期16"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别16" prop="c38x16">
              <el-input v-model="queryParams.c38x16" placeholder="请输入其他手术操作级别16" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者16" prop="c39x16">
              <el-input v-model="queryParams.c39x16" placeholder="请输入其他手术操作术者16" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助16" prop="c40x16">
              <el-input v-model="queryParams.c40x16" placeholder="请输入其他手术操作Ⅰ助16" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助16" prop="c41x16">
              <el-input v-model="queryParams.c41x16" placeholder="请输入其他手术操作Ⅱ助16" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级16" prop="c42x16c">
              <el-input v-model="queryParams.c42x16c" placeholder="请输入其他手术操作切口愈合等级16" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式16" prop="c43x16c">
              <el-input v-model="queryParams.c43x16c" placeholder="请输入其他手术操作麻醉方式16" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师16" prop="c44x16">
              <el-input v-model="queryParams.c44x16" placeholder="请输入其他手术操作麻醉医师16" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码17" prop="c35x17c">
              <el-input v-model="queryParams.c35x17c" placeholder="请输入其他手术操作编码17" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称17" prop="c36x17n">
              <el-input v-model="queryParams.c36x17n" placeholder="请输入其他手术操作名称17" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期17" prop="c37x17">
              <el-date-picker clearable
                v-model="queryParams.c37x17"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期17"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别17" prop="c38x17">
              <el-input v-model="queryParams.c38x17" placeholder="请输入其他手术操作级别17" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者17" prop="c39x17">
              <el-input v-model="queryParams.c39x17" placeholder="请输入其他手术操作术者17" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助17" prop="c40x17">
              <el-input v-model="queryParams.c40x17" placeholder="请输入其他手术操作Ⅰ助17" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助17" prop="c41x17">
              <el-input v-model="queryParams.c41x17" placeholder="请输入其他手术操作Ⅱ助17" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级17" prop="c42x17c">
              <el-input v-model="queryParams.c42x17c" placeholder="请输入其他手术操作切口愈合等级17" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式17" prop="c43x17c">
              <el-input v-model="queryParams.c43x17c" placeholder="请输入其他手术操作麻醉方式17" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师17" prop="c44x17">
              <el-input v-model="queryParams.c44x17" placeholder="请输入其他手术操作麻醉医师17" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码18" prop="c35x18c">
              <el-input v-model="queryParams.c35x18c" placeholder="请输入其他手术操作编码18" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称18" prop="c36x18n">
              <el-input v-model="queryParams.c36x18n" placeholder="请输入其他手术操作名称18" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期18" prop="c37x18">
              <el-date-picker clearable
                v-model="queryParams.c37x18"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期18"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别18" prop="c38x18">
              <el-input v-model="queryParams.c38x18" placeholder="请输入其他手术操作级别18" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者18" prop="c39x18">
              <el-input v-model="queryParams.c39x18" placeholder="请输入其他手术操作术者18" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助18" prop="c40x18">
              <el-input v-model="queryParams.c40x18" placeholder="请输入其他手术操作Ⅰ助18" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助18" prop="c41x18">
              <el-input v-model="queryParams.c41x18" placeholder="请输入其他手术操作Ⅱ助18" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级18" prop="c42x18c">
              <el-input v-model="queryParams.c42x18c" placeholder="请输入其他手术操作切口愈合等级18" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式18" prop="c43x18c">
              <el-input v-model="queryParams.c43x18c" placeholder="请输入其他手术操作麻醉方式18" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师18" prop="c44x18">
              <el-input v-model="queryParams.c44x18" placeholder="请输入其他手术操作麻醉医师18" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码19" prop="c35x19c">
              <el-input v-model="queryParams.c35x19c" placeholder="请输入其他手术操作编码19" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称19" prop="c36x19n">
              <el-input v-model="queryParams.c36x19n" placeholder="请输入其他手术操作名称19" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期19" prop="c37x19">
              <el-date-picker clearable
                v-model="queryParams.c37x19"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期19"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别19" prop="c38x19">
              <el-input v-model="queryParams.c38x19" placeholder="请输入其他手术操作级别19" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者19" prop="c39x19">
              <el-input v-model="queryParams.c39x19" placeholder="请输入其他手术操作术者19" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助19" prop="c40x19">
              <el-input v-model="queryParams.c40x19" placeholder="请输入其他手术操作Ⅰ助19" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助19" prop="c41x19">
              <el-input v-model="queryParams.c41x19" placeholder="请输入其他手术操作Ⅱ助19" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级19" prop="c42x19c">
              <el-input v-model="queryParams.c42x19c" placeholder="请输入其他手术操作切口愈合等级19" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式19" prop="c43x19c">
              <el-input v-model="queryParams.c43x19c" placeholder="请输入其他手术操作麻醉方式19" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师19" prop="c44x19">
              <el-input v-model="queryParams.c44x19" placeholder="请输入其他手术操作麻醉医师19" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码20" prop="c35x20c">
              <el-input v-model="queryParams.c35x20c" placeholder="请输入其他手术操作编码20" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称20" prop="c36x20n">
              <el-input v-model="queryParams.c36x20n" placeholder="请输入其他手术操作名称20" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期20" prop="c37x20">
              <el-date-picker clearable
                v-model="queryParams.c37x20"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期20"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别20" prop="c38x20">
              <el-input v-model="queryParams.c38x20" placeholder="请输入其他手术操作级别20" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者20" prop="c39x20">
              <el-input v-model="queryParams.c39x20" placeholder="请输入其他手术操作术者20" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助20" prop="c40x20">
              <el-input v-model="queryParams.c40x20" placeholder="请输入其他手术操作Ⅰ助20" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助20" prop="c41x20">
              <el-input v-model="queryParams.c41x20" placeholder="请输入其他手术操作Ⅱ助20" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级20" prop="c42x20c">
              <el-input v-model="queryParams.c42x20c" placeholder="请输入其他手术操作切口愈合等级20" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式20" prop="c43x20c">
              <el-input v-model="queryParams.c43x20c" placeholder="请输入其他手术操作麻醉方式20" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师20" prop="c44x20">
              <el-input v-model="queryParams.c44x20" placeholder="请输入其他手术操作麻醉医师20" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码21" prop="c35x21c">
              <el-input v-model="queryParams.c35x21c" placeholder="请输入其他手术操作编码21" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称21" prop="c36x21n">
              <el-input v-model="queryParams.c36x21n" placeholder="请输入其他手术操作名称21" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期21" prop="c37x21">
              <el-date-picker clearable
                v-model="queryParams.c37x21"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期21"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别21" prop="c38x21">
              <el-input v-model="queryParams.c38x21" placeholder="请输入其他手术操作级别21" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者21" prop="c39x21">
              <el-input v-model="queryParams.c39x21" placeholder="请输入其他手术操作术者21" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助21" prop="c40x21">
              <el-input v-model="queryParams.c40x21" placeholder="请输入其他手术操作Ⅰ助21" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助21" prop="c41x21">
              <el-input v-model="queryParams.c41x21" placeholder="请输入其他手术操作Ⅱ助21" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级21" prop="c42x21c">
              <el-input v-model="queryParams.c42x21c" placeholder="请输入其他手术操作切口愈合等级21" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式21" prop="c43x21c">
              <el-input v-model="queryParams.c43x21c" placeholder="请输入其他手术操作麻醉方式21" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师21" prop="c44x21">
              <el-input v-model="queryParams.c44x21" placeholder="请输入其他手术操作麻醉医师21" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码22" prop="c35x22c">
              <el-input v-model="queryParams.c35x22c" placeholder="请输入其他手术操作编码22" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称22" prop="c36x22n">
              <el-input v-model="queryParams.c36x22n" placeholder="请输入其他手术操作名称22" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期22" prop="c37x22">
              <el-date-picker clearable
                v-model="queryParams.c37x22"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期22"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别22" prop="c38x22">
              <el-input v-model="queryParams.c38x22" placeholder="请输入其他手术操作级别22" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者22" prop="c39x22">
              <el-input v-model="queryParams.c39x22" placeholder="请输入其他手术操作术者22" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助22" prop="c40x22">
              <el-input v-model="queryParams.c40x22" placeholder="请输入其他手术操作Ⅰ助22" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助22" prop="c41x22">
              <el-input v-model="queryParams.c41x22" placeholder="请输入其他手术操作Ⅱ助22" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级22" prop="c42x22c">
              <el-input v-model="queryParams.c42x22c" placeholder="请输入其他手术操作切口愈合等级22" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式22" prop="c43x22c">
              <el-input v-model="queryParams.c43x22c" placeholder="请输入其他手术操作麻醉方式22" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师22" prop="c44x22">
              <el-input v-model="queryParams.c44x22" placeholder="请输入其他手术操作麻醉医师22" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码23" prop="c35x23c">
              <el-input v-model="queryParams.c35x23c" placeholder="请输入其他手术操作编码23" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称23" prop="c36x23n">
              <el-input v-model="queryParams.c36x23n" placeholder="请输入其他手术操作名称23" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期23" prop="c37x23">
              <el-date-picker clearable
                v-model="queryParams.c37x23"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期23"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别23" prop="c38x23">
              <el-input v-model="queryParams.c38x23" placeholder="请输入其他手术操作级别23" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者23" prop="c39x23">
              <el-input v-model="queryParams.c39x23" placeholder="请输入其他手术操作术者23" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助23" prop="c40x23">
              <el-input v-model="queryParams.c40x23" placeholder="请输入其他手术操作Ⅰ助23" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助23" prop="c41x23">
              <el-input v-model="queryParams.c41x23" placeholder="请输入其他手术操作Ⅱ助23" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级23" prop="c42x23c">
              <el-input v-model="queryParams.c42x23c" placeholder="请输入其他手术操作切口愈合等级23" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式23" prop="c43x23c">
              <el-input v-model="queryParams.c43x23c" placeholder="请输入其他手术操作麻醉方式23" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师23" prop="c44x23">
              <el-input v-model="queryParams.c44x23" placeholder="请输入其他手术操作麻醉医师23" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码24" prop="c35x24c">
              <el-input v-model="queryParams.c35x24c" placeholder="请输入其他手术操作编码24" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称24" prop="c36x24n">
              <el-input v-model="queryParams.c36x24n" placeholder="请输入其他手术操作名称24" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期24" prop="c37x24">
              <el-date-picker clearable
                v-model="queryParams.c37x24"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期24"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别24" prop="c38x24">
              <el-input v-model="queryParams.c38x24" placeholder="请输入其他手术操作级别24" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者24" prop="c39x24">
              <el-input v-model="queryParams.c39x24" placeholder="请输入其他手术操作术者24" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助24" prop="c40x24">
              <el-input v-model="queryParams.c40x24" placeholder="请输入其他手术操作Ⅰ助24" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助24" prop="c41x24">
              <el-input v-model="queryParams.c41x24" placeholder="请输入其他手术操作Ⅱ助24" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级24" prop="c42x24c">
              <el-input v-model="queryParams.c42x24c" placeholder="请输入其他手术操作切口愈合等级24" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式24" prop="c43x24c">
              <el-input v-model="queryParams.c43x24c" placeholder="请输入其他手术操作麻醉方式24" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师24" prop="c44x24">
              <el-input v-model="queryParams.c44x24" placeholder="请输入其他手术操作麻醉医师24" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码25" prop="c35x25c">
              <el-input v-model="queryParams.c35x25c" placeholder="请输入其他手术操作编码25" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称25" prop="c36x25n">
              <el-input v-model="queryParams.c36x25n" placeholder="请输入其他手术操作名称25" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期25" prop="c37x25">
              <el-date-picker clearable
                v-model="queryParams.c37x25"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期25"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别25" prop="c38x25">
              <el-input v-model="queryParams.c38x25" placeholder="请输入其他手术操作级别25" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者25" prop="c39x25">
              <el-input v-model="queryParams.c39x25" placeholder="请输入其他手术操作术者25" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助25" prop="c40x25">
              <el-input v-model="queryParams.c40x25" placeholder="请输入其他手术操作Ⅰ助25" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助25" prop="c41x25">
              <el-input v-model="queryParams.c41x25" placeholder="请输入其他手术操作Ⅱ助25" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级25" prop="c42x25c">
              <el-input v-model="queryParams.c42x25c" placeholder="请输入其他手术操作切口愈合等级25" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式25" prop="c43x25c">
              <el-input v-model="queryParams.c43x25c" placeholder="请输入其他手术操作麻醉方式25" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师25" prop="c44x25">
              <el-input v-model="queryParams.c44x25" placeholder="请输入其他手术操作麻醉医师25" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码26" prop="c35x26c">
              <el-input v-model="queryParams.c35x26c" placeholder="请输入其他手术操作编码26" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称26" prop="c36x26n">
              <el-input v-model="queryParams.c36x26n" placeholder="请输入其他手术操作名称26" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期26" prop="c37x26">
              <el-date-picker clearable
                v-model="queryParams.c37x26"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期26"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别26" prop="c38x26">
              <el-input v-model="queryParams.c38x26" placeholder="请输入其他手术操作级别26" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者26" prop="c39x26">
              <el-input v-model="queryParams.c39x26" placeholder="请输入其他手术操作术者26" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助26" prop="c40x26">
              <el-input v-model="queryParams.c40x26" placeholder="请输入其他手术操作Ⅰ助26" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助26" prop="c41x26">
              <el-input v-model="queryParams.c41x26" placeholder="请输入其他手术操作Ⅱ助26" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级26" prop="c42x26c">
              <el-input v-model="queryParams.c42x26c" placeholder="请输入其他手术操作切口愈合等级26" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式26" prop="c43x26c">
              <el-input v-model="queryParams.c43x26c" placeholder="请输入其他手术操作麻醉方式26" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师26" prop="c44x26">
              <el-input v-model="queryParams.c44x26" placeholder="请输入其他手术操作麻醉医师26" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码27" prop="c35x27c">
              <el-input v-model="queryParams.c35x27c" placeholder="请输入其他手术操作编码27" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称27" prop="c36x27n">
              <el-input v-model="queryParams.c36x27n" placeholder="请输入其他手术操作名称27" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期27" prop="c37x27">
              <el-date-picker clearable
                v-model="queryParams.c37x27"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期27"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别27" prop="c38x27">
              <el-input v-model="queryParams.c38x27" placeholder="请输入其他手术操作级别27" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者27" prop="c39x27">
              <el-input v-model="queryParams.c39x27" placeholder="请输入其他手术操作术者27" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助27" prop="c40x27">
              <el-input v-model="queryParams.c40x27" placeholder="请输入其他手术操作Ⅰ助27" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助27" prop="c41x27">
              <el-input v-model="queryParams.c41x27" placeholder="请输入其他手术操作Ⅱ助27" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级27" prop="c42x27c">
              <el-input v-model="queryParams.c42x27c" placeholder="请输入其他手术操作切口愈合等级27" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式27" prop="c43x27c">
              <el-input v-model="queryParams.c43x27c" placeholder="请输入其他手术操作麻醉方式27" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师27" prop="c44x27">
              <el-input v-model="queryParams.c44x27" placeholder="请输入其他手术操作麻醉医师27" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码28" prop="c35x28c">
              <el-input v-model="queryParams.c35x28c" placeholder="请输入其他手术操作编码28" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称28" prop="c36x28n">
              <el-input v-model="queryParams.c36x28n" placeholder="请输入其他手术操作名称28" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期28" prop="c37x28">
              <el-date-picker clearable
                v-model="queryParams.c37x28"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期28"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别28" prop="c38x28">
              <el-input v-model="queryParams.c38x28" placeholder="请输入其他手术操作级别28" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者28" prop="c39x28">
              <el-input v-model="queryParams.c39x28" placeholder="请输入其他手术操作术者28" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助28" prop="c40x28">
              <el-input v-model="queryParams.c40x28" placeholder="请输入其他手术操作Ⅰ助28" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助28" prop="c41x28">
              <el-input v-model="queryParams.c41x28" placeholder="请输入其他手术操作Ⅱ助28" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级28" prop="c42x28c">
              <el-input v-model="queryParams.c42x28c" placeholder="请输入其他手术操作切口愈合等级28" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式28" prop="c43x28c">
              <el-input v-model="queryParams.c43x28c" placeholder="请输入其他手术操作麻醉方式28" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师28" prop="c44x28">
              <el-input v-model="queryParams.c44x28" placeholder="请输入其他手术操作麻醉医师28" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码29" prop="c35x29c">
              <el-input v-model="queryParams.c35x29c" placeholder="请输入其他手术操作编码29" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称29" prop="c36x29n">
              <el-input v-model="queryParams.c36x29n" placeholder="请输入其他手术操作名称29" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期29" prop="c37x29">
              <el-date-picker clearable
                v-model="queryParams.c37x29"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期29"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别29" prop="c38x29">
              <el-input v-model="queryParams.c38x29" placeholder="请输入其他手术操作级别29" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者29" prop="c39x29">
              <el-input v-model="queryParams.c39x29" placeholder="请输入其他手术操作术者29" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助29" prop="c40x29">
              <el-input v-model="queryParams.c40x29" placeholder="请输入其他手术操作Ⅰ助29" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助29" prop="c41x29">
              <el-input v-model="queryParams.c41x29" placeholder="请输入其他手术操作Ⅱ助29" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级29" prop="c42x29c">
              <el-input v-model="queryParams.c42x29c" placeholder="请输入其他手术操作切口愈合等级29" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式29" prop="c43x29c">
              <el-input v-model="queryParams.c43x29c" placeholder="请输入其他手术操作麻醉方式29" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师29" prop="c44x29">
              <el-input v-model="queryParams.c44x29" placeholder="请输入其他手术操作麻醉医师29" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码30" prop="c35x30c">
              <el-input v-model="queryParams.c35x30c" placeholder="请输入其他手术操作编码30" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称30" prop="c36x30n">
              <el-input v-model="queryParams.c36x30n" placeholder="请输入其他手术操作名称30" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期30" prop="c37x30">
              <el-date-picker clearable
                v-model="queryParams.c37x30"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期30"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别30" prop="c38x30">
              <el-input v-model="queryParams.c38x30" placeholder="请输入其他手术操作级别30" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者30" prop="c39x30">
              <el-input v-model="queryParams.c39x30" placeholder="请输入其他手术操作术者30" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助30" prop="c40x30">
              <el-input v-model="queryParams.c40x30" placeholder="请输入其他手术操作Ⅰ助30" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助30" prop="c41x30">
              <el-input v-model="queryParams.c41x30" placeholder="请输入其他手术操作Ⅱ助30" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级30" prop="c42x30c">
              <el-input v-model="queryParams.c42x30c" placeholder="请输入其他手术操作切口愈合等级30" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式30" prop="c43x30c">
              <el-input v-model="queryParams.c43x30c" placeholder="请输入其他手术操作麻醉方式30" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师30" prop="c44x30">
              <el-input v-model="queryParams.c44x30" placeholder="请输入其他手术操作麻醉医师30" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码31" prop="c35x31c">
              <el-input v-model="queryParams.c35x31c" placeholder="请输入其他手术操作编码31" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称31" prop="c36x31n">
              <el-input v-model="queryParams.c36x31n" placeholder="请输入其他手术操作名称31" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期31" prop="c37x31">
              <el-date-picker clearable
                v-model="queryParams.c37x31"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期31"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别31" prop="c38x31">
              <el-input v-model="queryParams.c38x31" placeholder="请输入其他手术操作级别31" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者31" prop="c39x31">
              <el-input v-model="queryParams.c39x31" placeholder="请输入其他手术操作术者31" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助31" prop="c40x31">
              <el-input v-model="queryParams.c40x31" placeholder="请输入其他手术操作Ⅰ助31" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助31" prop="c41x31">
              <el-input v-model="queryParams.c41x31" placeholder="请输入其他手术操作Ⅱ助31" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级31" prop="c42x31c">
              <el-input v-model="queryParams.c42x31c" placeholder="请输入其他手术操作切口愈合等级31" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式31" prop="c43x31c">
              <el-input v-model="queryParams.c43x31c" placeholder="请输入其他手术操作麻醉方式31" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师31" prop="c44x31">
              <el-input v-model="queryParams.c44x31" placeholder="请输入其他手术操作麻醉医师31" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码32" prop="c35x32c">
              <el-input v-model="queryParams.c35x32c" placeholder="请输入其他手术操作编码32" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称32" prop="c36x32n">
              <el-input v-model="queryParams.c36x32n" placeholder="请输入其他手术操作名称32" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期32" prop="c37x32">
              <el-date-picker clearable
                v-model="queryParams.c37x32"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期32"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别32" prop="c38x32">
              <el-input v-model="queryParams.c38x32" placeholder="请输入其他手术操作级别32" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者32" prop="c39x32">
              <el-input v-model="queryParams.c39x32" placeholder="请输入其他手术操作术者32" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助32" prop="c40x32">
              <el-input v-model="queryParams.c40x32" placeholder="请输入其他手术操作Ⅰ助32" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助32" prop="c41x32">
              <el-input v-model="queryParams.c41x32" placeholder="请输入其他手术操作Ⅱ助32" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级32" prop="c42x32c">
              <el-input v-model="queryParams.c42x32c" placeholder="请输入其他手术操作切口愈合等级32" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式32" prop="c43x32c">
              <el-input v-model="queryParams.c43x32c" placeholder="请输入其他手术操作麻醉方式32" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师32" prop="c44x32">
              <el-input v-model="queryParams.c44x32" placeholder="请输入其他手术操作麻醉医师32" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码33" prop="c35x33c">
              <el-input v-model="queryParams.c35x33c" placeholder="请输入其他手术操作编码33" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称33" prop="c36x33n">
              <el-input v-model="queryParams.c36x33n" placeholder="请输入其他手术操作名称33" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期33" prop="c37x33">
              <el-date-picker clearable
                v-model="queryParams.c37x33"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期33"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别33" prop="c38x33">
              <el-input v-model="queryParams.c38x33" placeholder="请输入其他手术操作级别33" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者33" prop="c39x33">
              <el-input v-model="queryParams.c39x33" placeholder="请输入其他手术操作术者33" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助33" prop="c40x33">
              <el-input v-model="queryParams.c40x33" placeholder="请输入其他手术操作Ⅰ助33" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助33" prop="c41x33">
              <el-input v-model="queryParams.c41x33" placeholder="请输入其他手术操作Ⅱ助33" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级33" prop="c42x33c">
              <el-input v-model="queryParams.c42x33c" placeholder="请输入其他手术操作切口愈合等级33" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式33" prop="c43x33c">
              <el-input v-model="queryParams.c43x33c" placeholder="请输入其他手术操作麻醉方式33" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师33" prop="c44x33">
              <el-input v-model="queryParams.c44x33" placeholder="请输入其他手术操作麻醉医师33" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码34" prop="c35x34c">
              <el-input v-model="queryParams.c35x34c" placeholder="请输入其他手术操作编码34" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称34" prop="c36x34n">
              <el-input v-model="queryParams.c36x34n" placeholder="请输入其他手术操作名称34" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期34" prop="c37x34">
              <el-date-picker clearable
                v-model="queryParams.c37x34"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期34"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别34" prop="c38x34">
              <el-input v-model="queryParams.c38x34" placeholder="请输入其他手术操作级别34" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者34" prop="c39x34">
              <el-input v-model="queryParams.c39x34" placeholder="请输入其他手术操作术者34" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助34" prop="c40x34">
              <el-input v-model="queryParams.c40x34" placeholder="请输入其他手术操作Ⅰ助34" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助34" prop="c41x34">
              <el-input v-model="queryParams.c41x34" placeholder="请输入其他手术操作Ⅱ助34" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级34" prop="c42x34c">
              <el-input v-model="queryParams.c42x34c" placeholder="请输入其他手术操作切口愈合等级34" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式34" prop="c43x34c">
              <el-input v-model="queryParams.c43x34c" placeholder="请输入其他手术操作麻醉方式34" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师34" prop="c44x34">
              <el-input v-model="queryParams.c44x34" placeholder="请输入其他手术操作麻醉医师34" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码35" prop="c35x35c">
              <el-input v-model="queryParams.c35x35c" placeholder="请输入其他手术操作编码35" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称35" prop="c36x35n">
              <el-input v-model="queryParams.c36x35n" placeholder="请输入其他手术操作名称35" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期35" prop="c37x35">
              <el-date-picker clearable
                v-model="queryParams.c37x35"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期35"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别35" prop="c38x35">
              <el-input v-model="queryParams.c38x35" placeholder="请输入其他手术操作级别35" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者35" prop="c39x35">
              <el-input v-model="queryParams.c39x35" placeholder="请输入其他手术操作术者35" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助35" prop="c40x35">
              <el-input v-model="queryParams.c40x35" placeholder="请输入其他手术操作Ⅰ助35" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助35" prop="c41x35">
              <el-input v-model="queryParams.c41x35" placeholder="请输入其他手术操作Ⅱ助35" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级35" prop="c42x35c">
              <el-input v-model="queryParams.c42x35c" placeholder="请输入其他手术操作切口愈合等级35" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式35" prop="c43x35c">
              <el-input v-model="queryParams.c43x35c" placeholder="请输入其他手术操作麻醉方式35" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师35" prop="c44x35">
              <el-input v-model="queryParams.c44x35" placeholder="请输入其他手术操作麻醉医师35" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码36" prop="c35x36c">
              <el-input v-model="queryParams.c35x36c" placeholder="请输入其他手术操作编码36" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称36" prop="c36x36n">
              <el-input v-model="queryParams.c36x36n" placeholder="请输入其他手术操作名称36" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期36" prop="c37x36">
              <el-date-picker clearable
                v-model="queryParams.c37x36"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期36"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别36" prop="c38x36">
              <el-input v-model="queryParams.c38x36" placeholder="请输入其他手术操作级别36" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者36" prop="c39x36">
              <el-input v-model="queryParams.c39x36" placeholder="请输入其他手术操作术者36" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助36" prop="c40x36">
              <el-input v-model="queryParams.c40x36" placeholder="请输入其他手术操作Ⅰ助36" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助36" prop="c41x36">
              <el-input v-model="queryParams.c41x36" placeholder="请输入其他手术操作Ⅱ助36" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级36" prop="c42x36c">
              <el-input v-model="queryParams.c42x36c" placeholder="请输入其他手术操作切口愈合等级36" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式36" prop="c43x36c">
              <el-input v-model="queryParams.c43x36c" placeholder="请输入其他手术操作麻醉方式36" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师36" prop="c44x36">
              <el-input v-model="queryParams.c44x36" placeholder="请输入其他手术操作麻醉医师36" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码37" prop="c35x37c">
              <el-input v-model="queryParams.c35x37c" placeholder="请输入其他手术操作编码37" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称37" prop="c36x37n">
              <el-input v-model="queryParams.c36x37n" placeholder="请输入其他手术操作名称37" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期37" prop="c37x37">
              <el-date-picker clearable
                v-model="queryParams.c37x37"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期37"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别37" prop="c38x37">
              <el-input v-model="queryParams.c38x37" placeholder="请输入其他手术操作级别37" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者37" prop="c39x37">
              <el-input v-model="queryParams.c39x37" placeholder="请输入其他手术操作术者37" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助37" prop="c40x37">
              <el-input v-model="queryParams.c40x37" placeholder="请输入其他手术操作Ⅰ助37" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助37" prop="c41x37">
              <el-input v-model="queryParams.c41x37" placeholder="请输入其他手术操作Ⅱ助37" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级37" prop="c42x37c">
              <el-input v-model="queryParams.c42x37c" placeholder="请输入其他手术操作切口愈合等级37" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式37" prop="c43x37c">
              <el-input v-model="queryParams.c43x37c" placeholder="请输入其他手术操作麻醉方式37" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师37" prop="c44x37">
              <el-input v-model="queryParams.c44x37" placeholder="请输入其他手术操作麻醉医师37" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码38" prop="c35x38c">
              <el-input v-model="queryParams.c35x38c" placeholder="请输入其他手术操作编码38" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称38" prop="c36x38n">
              <el-input v-model="queryParams.c36x38n" placeholder="请输入其他手术操作名称38" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期38" prop="c37x38">
              <el-date-picker clearable
                v-model="queryParams.c37x38"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期38"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别38" prop="c38x38">
              <el-input v-model="queryParams.c38x38" placeholder="请输入其他手术操作级别38" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者38" prop="c39x38">
              <el-input v-model="queryParams.c39x38" placeholder="请输入其他手术操作术者38" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助38" prop="c40x38">
              <el-input v-model="queryParams.c40x38" placeholder="请输入其他手术操作Ⅰ助38" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助38" prop="c41x38">
              <el-input v-model="queryParams.c41x38" placeholder="请输入其他手术操作Ⅱ助38" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级38" prop="c42x38c">
              <el-input v-model="queryParams.c42x38c" placeholder="请输入其他手术操作切口愈合等级38" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式38" prop="c43x38c">
              <el-input v-model="queryParams.c43x38c" placeholder="请输入其他手术操作麻醉方式38" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师38" prop="c44x38">
              <el-input v-model="queryParams.c44x38" placeholder="请输入其他手术操作麻醉医师38" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码39" prop="c35x39c">
              <el-input v-model="queryParams.c35x39c" placeholder="请输入其他手术操作编码39" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称39" prop="c36x39n">
              <el-input v-model="queryParams.c36x39n" placeholder="请输入其他手术操作名称39" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期39" prop="c37x39">
              <el-date-picker clearable
                v-model="queryParams.c37x39"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期39"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别39" prop="c38x39">
              <el-input v-model="queryParams.c38x39" placeholder="请输入其他手术操作级别39" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者39" prop="c39x39">
              <el-input v-model="queryParams.c39x39" placeholder="请输入其他手术操作术者39" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助39" prop="c40x39">
              <el-input v-model="queryParams.c40x39" placeholder="请输入其他手术操作Ⅰ助39" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助39" prop="c41x39">
              <el-input v-model="queryParams.c41x39" placeholder="请输入其他手术操作Ⅱ助39" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级39" prop="c42x39c">
              <el-input v-model="queryParams.c42x39c" placeholder="请输入其他手术操作切口愈合等级39" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式39" prop="c43x39c">
              <el-input v-model="queryParams.c43x39c" placeholder="请输入其他手术操作麻醉方式39" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师39" prop="c44x39">
              <el-input v-model="queryParams.c44x39" placeholder="请输入其他手术操作麻醉医师39" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作编码40" prop="c35x40c">
              <el-input v-model="queryParams.c35x40c" placeholder="请输入其他手术操作编码40" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作名称40" prop="c36x40n">
              <el-input v-model="queryParams.c36x40n" placeholder="请输入其他手术操作名称40" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作日期40" prop="c37x40">
              <el-date-picker clearable
                v-model="queryParams.c37x40"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择其他手术操作日期40"
              />
            </el-form-item>
            <el-form-item label="其他手术操作级别40" prop="c38x40">
              <el-input v-model="queryParams.c38x40" placeholder="请输入其他手术操作级别40" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作术者40" prop="c39x40">
              <el-input v-model="queryParams.c39x40" placeholder="请输入其他手术操作术者40" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅰ助40" prop="c40x40">
              <el-input v-model="queryParams.c40x40" placeholder="请输入其他手术操作Ⅰ助40" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作Ⅱ助40" prop="c41x40">
              <el-input v-model="queryParams.c41x40" placeholder="请输入其他手术操作Ⅱ助40" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作切口愈合等级40" prop="c42x40c">
              <el-input v-model="queryParams.c42x40c" placeholder="请输入其他手术操作切口愈合等级40" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉方式40" prop="c43x40c">
              <el-input v-model="queryParams.c43x40c" placeholder="请输入其他手术操作麻醉方式40" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其他手术操作麻醉医师40" prop="c44x40">
              <el-input v-model="queryParams.c44x40" placeholder="请输入其他手术操作麻醉医师40" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="住院总费用" prop="d01">
              <el-input v-model="queryParams.d01" placeholder="请输入住院总费用" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="住院总费用其中自付金额" prop="d09">
              <el-input v-model="queryParams.d09" placeholder="请输入住院总费用其中自付金额" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="1.一般医疗服务费" prop="d11">
              <el-input v-model="queryParams.d11" placeholder="请输入1.一般医疗服务费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="2.一般治疗操作费" prop="d12">
              <el-input v-model="queryParams.d12" placeholder="请输入2.一般治疗操作费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="3.护理费" prop="d13">
              <el-input v-model="queryParams.d13" placeholder="请输入3.护理费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="4.综合医疗服务类其他费用" prop="d14">
              <el-input v-model="queryParams.d14" placeholder="请输入4.综合医疗服务类其他费用" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="5.病理诊断费" prop="d15">
              <el-input v-model="queryParams.d15" placeholder="请输入5.病理诊断费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="6.实验室诊断费" prop="d16">
              <el-input v-model="queryParams.d16" placeholder="请输入6.实验室诊断费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="7.影像学诊断费" prop="d17">
              <el-input v-model="queryParams.d17" placeholder="请输入7.影像学诊断费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="8.临床诊断项目费" prop="d18">
              <el-input v-model="queryParams.d18" placeholder="请输入8.临床诊断项目费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="9.非手术治疗项目费" prop="d19">
              <el-input v-model="queryParams.d19" placeholder="请输入9.非手术治疗项目费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其中:临床物理治疗费" prop="d19x01">
              <el-input v-model="queryParams.d19x01" placeholder="请输入其中:临床物理治疗费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="10.手术治疗费" prop="d20">
              <el-input v-model="queryParams.d20" placeholder="请输入10.手术治疗费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其中:麻醉费" prop="d20x01">
              <el-input v-model="queryParams.d20x01" placeholder="请输入其中:麻醉费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其中:手术费" prop="d20x02">
              <el-input v-model="queryParams.d20x02" placeholder="请输入其中:手术费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="11.康复费" prop="d21">
              <el-input v-model="queryParams.d21" placeholder="请输入11.康复费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="12.中医治疗费" prop="d22">
              <el-input v-model="queryParams.d22" placeholder="请输入12.中医治疗费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="13.西药费" prop="d23">
              <el-input v-model="queryParams.d23" placeholder="请输入13.西药费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="其中:抗菌药物费" prop="d23x01">
              <el-input v-model="queryParams.d23x01" placeholder="请输入其中:抗菌药物费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="14.中成药费" prop="d24">
              <el-input v-model="queryParams.d24" placeholder="请输入14.中成药费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="15.中草药费" prop="d25">
              <el-input v-model="queryParams.d25" placeholder="请输入15.中草药费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="16.血费" prop="d26">
              <el-input v-model="queryParams.d26" placeholder="请输入16.血费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="17.白蛋白类制品费" prop="d27">
              <el-input v-model="queryParams.d27" placeholder="请输入17.白蛋白类制品费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="18.球蛋白类制品费" prop="d28">
              <el-input v-model="queryParams.d28" placeholder="请输入18.球蛋白类制品费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="19.凝血因子类制品费" prop="d29">
              <el-input v-model="queryParams.d29" placeholder="请输入19.凝血因子类制品费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="20.细胞因子类制品费" prop="d30">
              <el-input v-model="queryParams.d30" placeholder="请输入20.细胞因子类制品费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="21.检查用一次性医用材料费" prop="d31">
              <el-input v-model="queryParams.d31" placeholder="请输入21.检查用一次性医用材料费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="22.治疗用一次性医用材料费" prop="d32">
              <el-input v-model="queryParams.d32" placeholder="请输入22.治疗用一次性医用材料费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="23.手术用一次性医用材料费" prop="d33">
              <el-input v-model="queryParams.d33" placeholder="请输入23.手术用一次性医用材料费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="24.其他费" prop="d34">
              <el-input v-model="queryParams.d34" placeholder="请输入24.其他费" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="扩展字段1-预留" prop="e01">
              <el-input v-model="queryParams.e01" placeholder="请输入扩展字段1-预留" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="扩展字段2-预留" prop="e02">
              <el-input v-model="queryParams.e02" placeholder="请输入扩展字段2-预留" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="扩展字段3-预留" prop="e03">
              <el-input v-model="queryParams.e03" placeholder="请输入扩展字段3-预留" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="扩展字段4-预留" prop="e04">
              <el-input v-model="queryParams.e04" placeholder="请输入扩展字段4-预留" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="扩展字段5-预留时间" prop="e05">
              <el-date-picker clearable
                v-model="queryParams.e05"
                type="date"
                value-format="YYYY-MM-DD"
                placeholder="请选择扩展字段5-预留时间"
              />
            </el-form-item>
            <el-form-item label="扩展字段6-预留金额" prop="e06">
              <el-input v-model="queryParams.e06" placeholder="请输入扩展字段6-预留金额" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="扩展字段7-预留数字" prop="e07">
              <el-input v-model="queryParams.e07" placeholder="请输入扩展字段7-预留数字" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="扩展字段8-预留文本" prop="e08">
              <el-input v-model="queryParams.e08" placeholder="请输入扩展字段8-预留文本" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="扩展字段9-预留布尔值" prop="e09">
              <el-input v-model="queryParams.e09" placeholder="请输入扩展字段9-预留布尔值" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="扩展字段10-预留编码" prop="e10">
              <el-input v-model="queryParams.e10" placeholder="请输入扩展字段10-预留编码" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['natdss:natdssB04MedicalRecordFrontSheetNonTcmSupplement:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['natdss:natdssB04MedicalRecordFrontSheetNonTcmSupplement:edit']">修改</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['natdss:natdssB04MedicalRecordFrontSheetNonTcmSupplement:remove']">删除</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['natdss:natdssB04MedicalRecordFrontSheetNonTcmSupplement:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="natdssB04MedicalRecordFrontSheetNonTcmSupplementList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="患者ID" align="center" prop="patientId" v-if="true" />
        <el-table-column label="单次就诊唯一标识号" align="center" prop="visitSn" v-if="true" />
        <el-table-column label="其他手术操作编码1" align="center" prop="c35x01c" />
        <el-table-column label="其他手术操作名称1" align="center" prop="c36x01n" />
        <el-table-column label="其他手术操作日期1" align="center" prop="c37x01" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x01, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别1" align="center" prop="c38x01" />
        <el-table-column label="其他手术操作术者1" align="center" prop="c39x01" />
        <el-table-column label="其他手术操作Ⅰ助1" align="center" prop="c40x01" />
        <el-table-column label="其他手术操作Ⅱ助1" align="center" prop="c41x01" />
        <el-table-column label="其他手术操作切口愈合等级1" align="center" prop="c42x01c" />
        <el-table-column label="其他手术操作麻醉方式1" align="center" prop="c43x01c" />
        <el-table-column label="其他手术操作麻醉医师1" align="center" prop="c44x01" />
        <el-table-column label="其他手术操作编码2" align="center" prop="c35x02c" />
        <el-table-column label="其他手术操作名称2" align="center" prop="c36x02n" />
        <el-table-column label="其他手术操作日期2" align="center" prop="c37x02" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x02, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别2" align="center" prop="c38x02" />
        <el-table-column label="其他手术操作术者2" align="center" prop="c39x02" />
        <el-table-column label="其他手术操作Ⅰ助2" align="center" prop="c40x02" />
        <el-table-column label="其他手术操作Ⅱ助2" align="center" prop="c41x02" />
        <el-table-column label="其他手术操作切口愈合等级2" align="center" prop="c42x02c" />
        <el-table-column label="其他手术操作麻醉方式2" align="center" prop="c43x02c" />
        <el-table-column label="其他手术操作麻醉医师2" align="center" prop="c44x02" />
        <el-table-column label="其他手术操作编码3" align="center" prop="c35x03c" />
        <el-table-column label="其他手术操作名称3" align="center" prop="c36x03n" />
        <el-table-column label="其他手术操作日期3" align="center" prop="c37x03" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x03, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别3" align="center" prop="c38x03" />
        <el-table-column label="其他手术操作术者3" align="center" prop="c39x03" />
        <el-table-column label="其他手术操作Ⅰ助3" align="center" prop="c40x03" />
        <el-table-column label="其他手术操作Ⅱ助3" align="center" prop="c41x03" />
        <el-table-column label="其他手术操作切口愈合等级3" align="center" prop="c42x03c" />
        <el-table-column label="其他手术操作麻醉方式3" align="center" prop="c43x03c" />
        <el-table-column label="其他手术操作麻醉医师3" align="center" prop="c44x03" />
        <el-table-column label="其他手术操作编码4" align="center" prop="c35x04c" />
        <el-table-column label="其他手术操作名称4" align="center" prop="c36x04n" />
        <el-table-column label="其他手术操作日期4" align="center" prop="c37x04" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x04, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别4" align="center" prop="c38x04" />
        <el-table-column label="其他手术操作术者4" align="center" prop="c39x04" />
        <el-table-column label="其他手术操作Ⅰ助4" align="center" prop="c40x04" />
        <el-table-column label="其他手术操作Ⅱ助4" align="center" prop="c41x04" />
        <el-table-column label="其他手术操作切口愈合等级4" align="center" prop="c42x04c" />
        <el-table-column label="其他手术操作麻醉方式4" align="center" prop="c43x04c" />
        <el-table-column label="其他手术操作麻醉医师4" align="center" prop="c44x04" />
        <el-table-column label="其他手术操作编码5" align="center" prop="c35x05c" />
        <el-table-column label="其他手术操作名称5" align="center" prop="c36x05n" />
        <el-table-column label="其他手术操作日期5" align="center" prop="c37x05" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x05, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别5" align="center" prop="c38x05" />
        <el-table-column label="其他手术操作术者5" align="center" prop="c39x05" />
        <el-table-column label="其他手术操作Ⅰ助5" align="center" prop="c40x05" />
        <el-table-column label="其他手术操作Ⅱ助5" align="center" prop="c41x05" />
        <el-table-column label="其他手术操作切口愈合等级5" align="center" prop="c42x05c" />
        <el-table-column label="其他手术操作麻醉方式5" align="center" prop="c43x05c" />
        <el-table-column label="其他手术操作麻醉医师5" align="center" prop="c44x05" />
        <el-table-column label="其他手术操作编码6" align="center" prop="c35x06c" />
        <el-table-column label="其他手术操作名称6" align="center" prop="c36x06n" />
        <el-table-column label="其他手术操作日期6" align="center" prop="c37x06" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x06, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别6" align="center" prop="c38x06" />
        <el-table-column label="其他手术操作术者6" align="center" prop="c39x06" />
        <el-table-column label="其他手术操作Ⅰ助6" align="center" prop="c40x06" />
        <el-table-column label="其他手术操作Ⅱ助6" align="center" prop="c41x06" />
        <el-table-column label="其他手术操作切口愈合等级6" align="center" prop="c42x06c" />
        <el-table-column label="其他手术操作麻醉方式6" align="center" prop="c43x06c" />
        <el-table-column label="其他手术操作麻醉医师6" align="center" prop="c44x06" />
        <el-table-column label="其他手术操作编码7" align="center" prop="c35x07c" />
        <el-table-column label="其他手术操作名称7" align="center" prop="c36x07n" />
        <el-table-column label="其他手术操作日期7" align="center" prop="c37x07" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x07, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别7" align="center" prop="c38x07" />
        <el-table-column label="其他手术操作术者7" align="center" prop="c39x07" />
        <el-table-column label="其他手术操作Ⅰ助7" align="center" prop="c40x07" />
        <el-table-column label="其他手术操作Ⅱ助7" align="center" prop="c41x07" />
        <el-table-column label="其他手术操作切口愈合等级7" align="center" prop="c42x07c" />
        <el-table-column label="其他手术操作麻醉方式7" align="center" prop="c43x07c" />
        <el-table-column label="其他手术操作麻醉医师7" align="center" prop="c44x07" />
        <el-table-column label="其他手术操作编码8" align="center" prop="c35x08c" />
        <el-table-column label="其他手术操作名称8" align="center" prop="c36x08n" />
        <el-table-column label="其他手术操作日期8" align="center" prop="c37x08" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x08, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别8" align="center" prop="c38x08" />
        <el-table-column label="其他手术操作术者8" align="center" prop="c39x08" />
        <el-table-column label="其他手术操作Ⅰ助8" align="center" prop="c40x08" />
        <el-table-column label="其他手术操作Ⅱ助8" align="center" prop="c41x08" />
        <el-table-column label="其他手术操作切口愈合等级8" align="center" prop="c42x08c" />
        <el-table-column label="其他手术操作麻醉方式8" align="center" prop="c43x08c" />
        <el-table-column label="其他手术操作麻醉医师8" align="center" prop="c44x08" />
        <el-table-column label="其他手术操作编码9" align="center" prop="c35x09c" />
        <el-table-column label="其他手术操作名称9" align="center" prop="c36x09n" />
        <el-table-column label="其他手术操作日期9" align="center" prop="c37x09" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x09, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别9" align="center" prop="c38x09" />
        <el-table-column label="其他手术操作术者9" align="center" prop="c39x09" />
        <el-table-column label="其他手术操作Ⅰ助9" align="center" prop="c40x09" />
        <el-table-column label="其他手术操作Ⅱ助9" align="center" prop="c41x09" />
        <el-table-column label="其他手术操作切口愈合等级9" align="center" prop="c42x09c" />
        <el-table-column label="其他手术操作麻醉方式9" align="center" prop="c43x09c" />
        <el-table-column label="其他手术操作麻醉医师9" align="center" prop="c44x09" />
        <el-table-column label="其他手术操作编码10" align="center" prop="c35x10c" />
        <el-table-column label="其他手术操作名称10" align="center" prop="c36x10n" />
        <el-table-column label="其他手术操作日期10" align="center" prop="c37x10" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x10, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别10" align="center" prop="c38x10" />
        <el-table-column label="其他手术操作术者10" align="center" prop="c39x10" />
        <el-table-column label="其他手术操作Ⅰ助10" align="center" prop="c40x10" />
        <el-table-column label="其他手术操作Ⅱ助10" align="center" prop="c41x10" />
        <el-table-column label="其他手术操作切口愈合等级10" align="center" prop="c42x10c" />
        <el-table-column label="其他手术操作麻醉方式10" align="center" prop="c43x10c" />
        <el-table-column label="其他手术操作麻醉医师10" align="center" prop="c44x10" />
        <el-table-column label="其他手术操作编码11" align="center" prop="c35x11c" />
        <el-table-column label="其他手术操作名称11" align="center" prop="c36x11n" />
        <el-table-column label="其他手术操作日期11" align="center" prop="c37x11" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x11, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别11" align="center" prop="c38x11" />
        <el-table-column label="其他手术操作术者11" align="center" prop="c39x11" />
        <el-table-column label="其他手术操作Ⅰ助11" align="center" prop="c40x11" />
        <el-table-column label="其他手术操作Ⅱ助11" align="center" prop="c41x11" />
        <el-table-column label="其他手术操作切口愈合等级11" align="center" prop="c42x11c" />
        <el-table-column label="其他手术操作麻醉方式11" align="center" prop="c43x11c" />
        <el-table-column label="其他手术操作麻醉医师11" align="center" prop="c44x11" />
        <el-table-column label="其他手术操作编码12" align="center" prop="c35x12c" />
        <el-table-column label="其他手术操作名称12" align="center" prop="c36x12n" />
        <el-table-column label="其他手术操作日期12" align="center" prop="c37x12" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x12, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别12" align="center" prop="c38x12" />
        <el-table-column label="其他手术操作术者12" align="center" prop="c39x12" />
        <el-table-column label="其他手术操作Ⅰ助12" align="center" prop="c40x12" />
        <el-table-column label="其他手术操作Ⅱ助12" align="center" prop="c41x12" />
        <el-table-column label="其他手术操作切口愈合等级12" align="center" prop="c42x12c" />
        <el-table-column label="其他手术操作麻醉方式12" align="center" prop="c43x12c" />
        <el-table-column label="其他手术操作麻醉医师12" align="center" prop="c44x12" />
        <el-table-column label="其他手术操作编码13" align="center" prop="c35x13c" />
        <el-table-column label="其他手术操作名称13" align="center" prop="c36x13n" />
        <el-table-column label="其他手术操作日期13" align="center" prop="c37x13" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x13, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别13" align="center" prop="c38x13" />
        <el-table-column label="其他手术操作术者13" align="center" prop="c39x13" />
        <el-table-column label="其他手术操作Ⅰ助13" align="center" prop="c40x13" />
        <el-table-column label="其他手术操作Ⅱ助13" align="center" prop="c41x13" />
        <el-table-column label="其他手术操作切口愈合等级13" align="center" prop="c42x13c" />
        <el-table-column label="其他手术操作麻醉方式13" align="center" prop="c43x13c" />
        <el-table-column label="其他手术操作麻醉医师13" align="center" prop="c44x13" />
        <el-table-column label="其他手术操作编码14" align="center" prop="c35x14c" />
        <el-table-column label="其他手术操作名称14" align="center" prop="c36x14n" />
        <el-table-column label="其他手术操作日期14" align="center" prop="c37x14" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x14, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别14" align="center" prop="c38x14" />
        <el-table-column label="其他手术操作术者14" align="center" prop="c39x14" />
        <el-table-column label="其他手术操作Ⅰ助14" align="center" prop="c40x14" />
        <el-table-column label="其他手术操作Ⅱ助14" align="center" prop="c41x14" />
        <el-table-column label="其他手术操作切口愈合等级14" align="center" prop="c42x14c" />
        <el-table-column label="其他手术操作麻醉方式14" align="center" prop="c43x14c" />
        <el-table-column label="其他手术操作麻醉医师14" align="center" prop="c44x14" />
        <el-table-column label="其他手术操作编码15" align="center" prop="c35x15c" />
        <el-table-column label="其他手术操作名称15" align="center" prop="c36x15n" />
        <el-table-column label="其他手术操作日期15" align="center" prop="c37x15" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x15, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别15" align="center" prop="c38x15" />
        <el-table-column label="其他手术操作术者15" align="center" prop="c39x15" />
        <el-table-column label="其他手术操作Ⅰ助15" align="center" prop="c40x15" />
        <el-table-column label="其他手术操作Ⅱ助15" align="center" prop="c41x15" />
        <el-table-column label="其他手术操作切口愈合等级15" align="center" prop="c42x15c" />
        <el-table-column label="其他手术操作麻醉方式15" align="center" prop="c43x15c" />
        <el-table-column label="其他手术操作麻醉医师15" align="center" prop="c44x15" />
        <el-table-column label="其他手术操作编码16" align="center" prop="c35x16c" />
        <el-table-column label="其他手术操作名称16" align="center" prop="c36x16n" />
        <el-table-column label="其他手术操作日期16" align="center" prop="c37x16" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x16, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别16" align="center" prop="c38x16" />
        <el-table-column label="其他手术操作术者16" align="center" prop="c39x16" />
        <el-table-column label="其他手术操作Ⅰ助16" align="center" prop="c40x16" />
        <el-table-column label="其他手术操作Ⅱ助16" align="center" prop="c41x16" />
        <el-table-column label="其他手术操作切口愈合等级16" align="center" prop="c42x16c" />
        <el-table-column label="其他手术操作麻醉方式16" align="center" prop="c43x16c" />
        <el-table-column label="其他手术操作麻醉医师16" align="center" prop="c44x16" />
        <el-table-column label="其他手术操作编码17" align="center" prop="c35x17c" />
        <el-table-column label="其他手术操作名称17" align="center" prop="c36x17n" />
        <el-table-column label="其他手术操作日期17" align="center" prop="c37x17" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x17, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别17" align="center" prop="c38x17" />
        <el-table-column label="其他手术操作术者17" align="center" prop="c39x17" />
        <el-table-column label="其他手术操作Ⅰ助17" align="center" prop="c40x17" />
        <el-table-column label="其他手术操作Ⅱ助17" align="center" prop="c41x17" />
        <el-table-column label="其他手术操作切口愈合等级17" align="center" prop="c42x17c" />
        <el-table-column label="其他手术操作麻醉方式17" align="center" prop="c43x17c" />
        <el-table-column label="其他手术操作麻醉医师17" align="center" prop="c44x17" />
        <el-table-column label="其他手术操作编码18" align="center" prop="c35x18c" />
        <el-table-column label="其他手术操作名称18" align="center" prop="c36x18n" />
        <el-table-column label="其他手术操作日期18" align="center" prop="c37x18" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x18, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别18" align="center" prop="c38x18" />
        <el-table-column label="其他手术操作术者18" align="center" prop="c39x18" />
        <el-table-column label="其他手术操作Ⅰ助18" align="center" prop="c40x18" />
        <el-table-column label="其他手术操作Ⅱ助18" align="center" prop="c41x18" />
        <el-table-column label="其他手术操作切口愈合等级18" align="center" prop="c42x18c" />
        <el-table-column label="其他手术操作麻醉方式18" align="center" prop="c43x18c" />
        <el-table-column label="其他手术操作麻醉医师18" align="center" prop="c44x18" />
        <el-table-column label="其他手术操作编码19" align="center" prop="c35x19c" />
        <el-table-column label="其他手术操作名称19" align="center" prop="c36x19n" />
        <el-table-column label="其他手术操作日期19" align="center" prop="c37x19" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x19, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别19" align="center" prop="c38x19" />
        <el-table-column label="其他手术操作术者19" align="center" prop="c39x19" />
        <el-table-column label="其他手术操作Ⅰ助19" align="center" prop="c40x19" />
        <el-table-column label="其他手术操作Ⅱ助19" align="center" prop="c41x19" />
        <el-table-column label="其他手术操作切口愈合等级19" align="center" prop="c42x19c" />
        <el-table-column label="其他手术操作麻醉方式19" align="center" prop="c43x19c" />
        <el-table-column label="其他手术操作麻醉医师19" align="center" prop="c44x19" />
        <el-table-column label="其他手术操作编码20" align="center" prop="c35x20c" />
        <el-table-column label="其他手术操作名称20" align="center" prop="c36x20n" />
        <el-table-column label="其他手术操作日期20" align="center" prop="c37x20" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x20, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别20" align="center" prop="c38x20" />
        <el-table-column label="其他手术操作术者20" align="center" prop="c39x20" />
        <el-table-column label="其他手术操作Ⅰ助20" align="center" prop="c40x20" />
        <el-table-column label="其他手术操作Ⅱ助20" align="center" prop="c41x20" />
        <el-table-column label="其他手术操作切口愈合等级20" align="center" prop="c42x20c" />
        <el-table-column label="其他手术操作麻醉方式20" align="center" prop="c43x20c" />
        <el-table-column label="其他手术操作麻醉医师20" align="center" prop="c44x20" />
        <el-table-column label="其他手术操作编码21" align="center" prop="c35x21c" />
        <el-table-column label="其他手术操作名称21" align="center" prop="c36x21n" />
        <el-table-column label="其他手术操作日期21" align="center" prop="c37x21" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x21, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别21" align="center" prop="c38x21" />
        <el-table-column label="其他手术操作术者21" align="center" prop="c39x21" />
        <el-table-column label="其他手术操作Ⅰ助21" align="center" prop="c40x21" />
        <el-table-column label="其他手术操作Ⅱ助21" align="center" prop="c41x21" />
        <el-table-column label="其他手术操作切口愈合等级21" align="center" prop="c42x21c" />
        <el-table-column label="其他手术操作麻醉方式21" align="center" prop="c43x21c" />
        <el-table-column label="其他手术操作麻醉医师21" align="center" prop="c44x21" />
        <el-table-column label="其他手术操作编码22" align="center" prop="c35x22c" />
        <el-table-column label="其他手术操作名称22" align="center" prop="c36x22n" />
        <el-table-column label="其他手术操作日期22" align="center" prop="c37x22" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x22, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别22" align="center" prop="c38x22" />
        <el-table-column label="其他手术操作术者22" align="center" prop="c39x22" />
        <el-table-column label="其他手术操作Ⅰ助22" align="center" prop="c40x22" />
        <el-table-column label="其他手术操作Ⅱ助22" align="center" prop="c41x22" />
        <el-table-column label="其他手术操作切口愈合等级22" align="center" prop="c42x22c" />
        <el-table-column label="其他手术操作麻醉方式22" align="center" prop="c43x22c" />
        <el-table-column label="其他手术操作麻醉医师22" align="center" prop="c44x22" />
        <el-table-column label="其他手术操作编码23" align="center" prop="c35x23c" />
        <el-table-column label="其他手术操作名称23" align="center" prop="c36x23n" />
        <el-table-column label="其他手术操作日期23" align="center" prop="c37x23" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x23, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别23" align="center" prop="c38x23" />
        <el-table-column label="其他手术操作术者23" align="center" prop="c39x23" />
        <el-table-column label="其他手术操作Ⅰ助23" align="center" prop="c40x23" />
        <el-table-column label="其他手术操作Ⅱ助23" align="center" prop="c41x23" />
        <el-table-column label="其他手术操作切口愈合等级23" align="center" prop="c42x23c" />
        <el-table-column label="其他手术操作麻醉方式23" align="center" prop="c43x23c" />
        <el-table-column label="其他手术操作麻醉医师23" align="center" prop="c44x23" />
        <el-table-column label="其他手术操作编码24" align="center" prop="c35x24c" />
        <el-table-column label="其他手术操作名称24" align="center" prop="c36x24n" />
        <el-table-column label="其他手术操作日期24" align="center" prop="c37x24" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x24, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别24" align="center" prop="c38x24" />
        <el-table-column label="其他手术操作术者24" align="center" prop="c39x24" />
        <el-table-column label="其他手术操作Ⅰ助24" align="center" prop="c40x24" />
        <el-table-column label="其他手术操作Ⅱ助24" align="center" prop="c41x24" />
        <el-table-column label="其他手术操作切口愈合等级24" align="center" prop="c42x24c" />
        <el-table-column label="其他手术操作麻醉方式24" align="center" prop="c43x24c" />
        <el-table-column label="其他手术操作麻醉医师24" align="center" prop="c44x24" />
        <el-table-column label="其他手术操作编码25" align="center" prop="c35x25c" />
        <el-table-column label="其他手术操作名称25" align="center" prop="c36x25n" />
        <el-table-column label="其他手术操作日期25" align="center" prop="c37x25" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x25, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别25" align="center" prop="c38x25" />
        <el-table-column label="其他手术操作术者25" align="center" prop="c39x25" />
        <el-table-column label="其他手术操作Ⅰ助25" align="center" prop="c40x25" />
        <el-table-column label="其他手术操作Ⅱ助25" align="center" prop="c41x25" />
        <el-table-column label="其他手术操作切口愈合等级25" align="center" prop="c42x25c" />
        <el-table-column label="其他手术操作麻醉方式25" align="center" prop="c43x25c" />
        <el-table-column label="其他手术操作麻醉医师25" align="center" prop="c44x25" />
        <el-table-column label="其他手术操作编码26" align="center" prop="c35x26c" />
        <el-table-column label="其他手术操作名称26" align="center" prop="c36x26n" />
        <el-table-column label="其他手术操作日期26" align="center" prop="c37x26" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x26, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别26" align="center" prop="c38x26" />
        <el-table-column label="其他手术操作术者26" align="center" prop="c39x26" />
        <el-table-column label="其他手术操作Ⅰ助26" align="center" prop="c40x26" />
        <el-table-column label="其他手术操作Ⅱ助26" align="center" prop="c41x26" />
        <el-table-column label="其他手术操作切口愈合等级26" align="center" prop="c42x26c" />
        <el-table-column label="其他手术操作麻醉方式26" align="center" prop="c43x26c" />
        <el-table-column label="其他手术操作麻醉医师26" align="center" prop="c44x26" />
        <el-table-column label="其他手术操作编码27" align="center" prop="c35x27c" />
        <el-table-column label="其他手术操作名称27" align="center" prop="c36x27n" />
        <el-table-column label="其他手术操作日期27" align="center" prop="c37x27" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x27, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别27" align="center" prop="c38x27" />
        <el-table-column label="其他手术操作术者27" align="center" prop="c39x27" />
        <el-table-column label="其他手术操作Ⅰ助27" align="center" prop="c40x27" />
        <el-table-column label="其他手术操作Ⅱ助27" align="center" prop="c41x27" />
        <el-table-column label="其他手术操作切口愈合等级27" align="center" prop="c42x27c" />
        <el-table-column label="其他手术操作麻醉方式27" align="center" prop="c43x27c" />
        <el-table-column label="其他手术操作麻醉医师27" align="center" prop="c44x27" />
        <el-table-column label="其他手术操作编码28" align="center" prop="c35x28c" />
        <el-table-column label="其他手术操作名称28" align="center" prop="c36x28n" />
        <el-table-column label="其他手术操作日期28" align="center" prop="c37x28" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x28, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别28" align="center" prop="c38x28" />
        <el-table-column label="其他手术操作术者28" align="center" prop="c39x28" />
        <el-table-column label="其他手术操作Ⅰ助28" align="center" prop="c40x28" />
        <el-table-column label="其他手术操作Ⅱ助28" align="center" prop="c41x28" />
        <el-table-column label="其他手术操作切口愈合等级28" align="center" prop="c42x28c" />
        <el-table-column label="其他手术操作麻醉方式28" align="center" prop="c43x28c" />
        <el-table-column label="其他手术操作麻醉医师28" align="center" prop="c44x28" />
        <el-table-column label="其他手术操作编码29" align="center" prop="c35x29c" />
        <el-table-column label="其他手术操作名称29" align="center" prop="c36x29n" />
        <el-table-column label="其他手术操作日期29" align="center" prop="c37x29" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x29, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别29" align="center" prop="c38x29" />
        <el-table-column label="其他手术操作术者29" align="center" prop="c39x29" />
        <el-table-column label="其他手术操作Ⅰ助29" align="center" prop="c40x29" />
        <el-table-column label="其他手术操作Ⅱ助29" align="center" prop="c41x29" />
        <el-table-column label="其他手术操作切口愈合等级29" align="center" prop="c42x29c" />
        <el-table-column label="其他手术操作麻醉方式29" align="center" prop="c43x29c" />
        <el-table-column label="其他手术操作麻醉医师29" align="center" prop="c44x29" />
        <el-table-column label="其他手术操作编码30" align="center" prop="c35x30c" />
        <el-table-column label="其他手术操作名称30" align="center" prop="c36x30n" />
        <el-table-column label="其他手术操作日期30" align="center" prop="c37x30" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x30, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别30" align="center" prop="c38x30" />
        <el-table-column label="其他手术操作术者30" align="center" prop="c39x30" />
        <el-table-column label="其他手术操作Ⅰ助30" align="center" prop="c40x30" />
        <el-table-column label="其他手术操作Ⅱ助30" align="center" prop="c41x30" />
        <el-table-column label="其他手术操作切口愈合等级30" align="center" prop="c42x30c" />
        <el-table-column label="其他手术操作麻醉方式30" align="center" prop="c43x30c" />
        <el-table-column label="其他手术操作麻醉医师30" align="center" prop="c44x30" />
        <el-table-column label="其他手术操作编码31" align="center" prop="c35x31c" />
        <el-table-column label="其他手术操作名称31" align="center" prop="c36x31n" />
        <el-table-column label="其他手术操作日期31" align="center" prop="c37x31" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x31, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别31" align="center" prop="c38x31" />
        <el-table-column label="其他手术操作术者31" align="center" prop="c39x31" />
        <el-table-column label="其他手术操作Ⅰ助31" align="center" prop="c40x31" />
        <el-table-column label="其他手术操作Ⅱ助31" align="center" prop="c41x31" />
        <el-table-column label="其他手术操作切口愈合等级31" align="center" prop="c42x31c" />
        <el-table-column label="其他手术操作麻醉方式31" align="center" prop="c43x31c" />
        <el-table-column label="其他手术操作麻醉医师31" align="center" prop="c44x31" />
        <el-table-column label="其他手术操作编码32" align="center" prop="c35x32c" />
        <el-table-column label="其他手术操作名称32" align="center" prop="c36x32n" />
        <el-table-column label="其他手术操作日期32" align="center" prop="c37x32" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x32, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别32" align="center" prop="c38x32" />
        <el-table-column label="其他手术操作术者32" align="center" prop="c39x32" />
        <el-table-column label="其他手术操作Ⅰ助32" align="center" prop="c40x32" />
        <el-table-column label="其他手术操作Ⅱ助32" align="center" prop="c41x32" />
        <el-table-column label="其他手术操作切口愈合等级32" align="center" prop="c42x32c" />
        <el-table-column label="其他手术操作麻醉方式32" align="center" prop="c43x32c" />
        <el-table-column label="其他手术操作麻醉医师32" align="center" prop="c44x32" />
        <el-table-column label="其他手术操作编码33" align="center" prop="c35x33c" />
        <el-table-column label="其他手术操作名称33" align="center" prop="c36x33n" />
        <el-table-column label="其他手术操作日期33" align="center" prop="c37x33" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x33, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别33" align="center" prop="c38x33" />
        <el-table-column label="其他手术操作术者33" align="center" prop="c39x33" />
        <el-table-column label="其他手术操作Ⅰ助33" align="center" prop="c40x33" />
        <el-table-column label="其他手术操作Ⅱ助33" align="center" prop="c41x33" />
        <el-table-column label="其他手术操作切口愈合等级33" align="center" prop="c42x33c" />
        <el-table-column label="其他手术操作麻醉方式33" align="center" prop="c43x33c" />
        <el-table-column label="其他手术操作麻醉医师33" align="center" prop="c44x33" />
        <el-table-column label="其他手术操作编码34" align="center" prop="c35x34c" />
        <el-table-column label="其他手术操作名称34" align="center" prop="c36x34n" />
        <el-table-column label="其他手术操作日期34" align="center" prop="c37x34" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x34, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别34" align="center" prop="c38x34" />
        <el-table-column label="其他手术操作术者34" align="center" prop="c39x34" />
        <el-table-column label="其他手术操作Ⅰ助34" align="center" prop="c40x34" />
        <el-table-column label="其他手术操作Ⅱ助34" align="center" prop="c41x34" />
        <el-table-column label="其他手术操作切口愈合等级34" align="center" prop="c42x34c" />
        <el-table-column label="其他手术操作麻醉方式34" align="center" prop="c43x34c" />
        <el-table-column label="其他手术操作麻醉医师34" align="center" prop="c44x34" />
        <el-table-column label="其他手术操作编码35" align="center" prop="c35x35c" />
        <el-table-column label="其他手术操作名称35" align="center" prop="c36x35n" />
        <el-table-column label="其他手术操作日期35" align="center" prop="c37x35" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x35, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别35" align="center" prop="c38x35" />
        <el-table-column label="其他手术操作术者35" align="center" prop="c39x35" />
        <el-table-column label="其他手术操作Ⅰ助35" align="center" prop="c40x35" />
        <el-table-column label="其他手术操作Ⅱ助35" align="center" prop="c41x35" />
        <el-table-column label="其他手术操作切口愈合等级35" align="center" prop="c42x35c" />
        <el-table-column label="其他手术操作麻醉方式35" align="center" prop="c43x35c" />
        <el-table-column label="其他手术操作麻醉医师35" align="center" prop="c44x35" />
        <el-table-column label="其他手术操作编码36" align="center" prop="c35x36c" />
        <el-table-column label="其他手术操作名称36" align="center" prop="c36x36n" />
        <el-table-column label="其他手术操作日期36" align="center" prop="c37x36" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x36, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别36" align="center" prop="c38x36" />
        <el-table-column label="其他手术操作术者36" align="center" prop="c39x36" />
        <el-table-column label="其他手术操作Ⅰ助36" align="center" prop="c40x36" />
        <el-table-column label="其他手术操作Ⅱ助36" align="center" prop="c41x36" />
        <el-table-column label="其他手术操作切口愈合等级36" align="center" prop="c42x36c" />
        <el-table-column label="其他手术操作麻醉方式36" align="center" prop="c43x36c" />
        <el-table-column label="其他手术操作麻醉医师36" align="center" prop="c44x36" />
        <el-table-column label="其他手术操作编码37" align="center" prop="c35x37c" />
        <el-table-column label="其他手术操作名称37" align="center" prop="c36x37n" />
        <el-table-column label="其他手术操作日期37" align="center" prop="c37x37" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x37, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别37" align="center" prop="c38x37" />
        <el-table-column label="其他手术操作术者37" align="center" prop="c39x37" />
        <el-table-column label="其他手术操作Ⅰ助37" align="center" prop="c40x37" />
        <el-table-column label="其他手术操作Ⅱ助37" align="center" prop="c41x37" />
        <el-table-column label="其他手术操作切口愈合等级37" align="center" prop="c42x37c" />
        <el-table-column label="其他手术操作麻醉方式37" align="center" prop="c43x37c" />
        <el-table-column label="其他手术操作麻醉医师37" align="center" prop="c44x37" />
        <el-table-column label="其他手术操作编码38" align="center" prop="c35x38c" />
        <el-table-column label="其他手术操作名称38" align="center" prop="c36x38n" />
        <el-table-column label="其他手术操作日期38" align="center" prop="c37x38" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x38, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别38" align="center" prop="c38x38" />
        <el-table-column label="其他手术操作术者38" align="center" prop="c39x38" />
        <el-table-column label="其他手术操作Ⅰ助38" align="center" prop="c40x38" />
        <el-table-column label="其他手术操作Ⅱ助38" align="center" prop="c41x38" />
        <el-table-column label="其他手术操作切口愈合等级38" align="center" prop="c42x38c" />
        <el-table-column label="其他手术操作麻醉方式38" align="center" prop="c43x38c" />
        <el-table-column label="其他手术操作麻醉医师38" align="center" prop="c44x38" />
        <el-table-column label="其他手术操作编码39" align="center" prop="c35x39c" />
        <el-table-column label="其他手术操作名称39" align="center" prop="c36x39n" />
        <el-table-column label="其他手术操作日期39" align="center" prop="c37x39" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x39, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别39" align="center" prop="c38x39" />
        <el-table-column label="其他手术操作术者39" align="center" prop="c39x39" />
        <el-table-column label="其他手术操作Ⅰ助39" align="center" prop="c40x39" />
        <el-table-column label="其他手术操作Ⅱ助39" align="center" prop="c41x39" />
        <el-table-column label="其他手术操作切口愈合等级39" align="center" prop="c42x39c" />
        <el-table-column label="其他手术操作麻醉方式39" align="center" prop="c43x39c" />
        <el-table-column label="其他手术操作麻醉医师39" align="center" prop="c44x39" />
        <el-table-column label="其他手术操作编码40" align="center" prop="c35x40c" />
        <el-table-column label="其他手术操作名称40" align="center" prop="c36x40n" />
        <el-table-column label="其他手术操作日期40" align="center" prop="c37x40" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.c37x40, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="其他手术操作级别40" align="center" prop="c38x40" />
        <el-table-column label="其他手术操作术者40" align="center" prop="c39x40" />
        <el-table-column label="其他手术操作Ⅰ助40" align="center" prop="c40x40" />
        <el-table-column label="其他手术操作Ⅱ助40" align="center" prop="c41x40" />
        <el-table-column label="其他手术操作切口愈合等级40" align="center" prop="c42x40c" />
        <el-table-column label="其他手术操作麻醉方式40" align="center" prop="c43x40c" />
        <el-table-column label="其他手术操作麻醉医师40" align="center" prop="c44x40" />
        <el-table-column label="住院总费用" align="center" prop="d01" />
        <el-table-column label="住院总费用其中自付金额" align="center" prop="d09" />
        <el-table-column label="1.一般医疗服务费" align="center" prop="d11" />
        <el-table-column label="2.一般治疗操作费" align="center" prop="d12" />
        <el-table-column label="3.护理费" align="center" prop="d13" />
        <el-table-column label="4.综合医疗服务类其他费用" align="center" prop="d14" />
        <el-table-column label="5.病理诊断费" align="center" prop="d15" />
        <el-table-column label="6.实验室诊断费" align="center" prop="d16" />
        <el-table-column label="7.影像学诊断费" align="center" prop="d17" />
        <el-table-column label="8.临床诊断项目费" align="center" prop="d18" />
        <el-table-column label="9.非手术治疗项目费" align="center" prop="d19" />
        <el-table-column label="其中:临床物理治疗费" align="center" prop="d19x01" />
        <el-table-column label="10.手术治疗费" align="center" prop="d20" />
        <el-table-column label="其中:麻醉费" align="center" prop="d20x01" />
        <el-table-column label="其中:手术费" align="center" prop="d20x02" />
        <el-table-column label="11.康复费" align="center" prop="d21" />
        <el-table-column label="12.中医治疗费" align="center" prop="d22" />
        <el-table-column label="13.西药费" align="center" prop="d23" />
        <el-table-column label="其中:抗菌药物费" align="center" prop="d23x01" />
        <el-table-column label="14.中成药费" align="center" prop="d24" />
        <el-table-column label="15.中草药费" align="center" prop="d25" />
        <el-table-column label="16.血费" align="center" prop="d26" />
        <el-table-column label="17.白蛋白类制品费" align="center" prop="d27" />
        <el-table-column label="18.球蛋白类制品费" align="center" prop="d28" />
        <el-table-column label="19.凝血因子类制品费" align="center" prop="d29" />
        <el-table-column label="20.细胞因子类制品费" align="center" prop="d30" />
        <el-table-column label="21.检查用一次性医用材料费" align="center" prop="d31" />
        <el-table-column label="22.治疗用一次性医用材料费" align="center" prop="d32" />
        <el-table-column label="23.手术用一次性医用材料费" align="center" prop="d33" />
        <el-table-column label="24.其他费" align="center" prop="d34" />
        <el-table-column label="扩展字段1-预留" align="center" prop="e01" />
        <el-table-column label="扩展字段2-预留" align="center" prop="e02" />
        <el-table-column label="扩展字段3-预留" align="center" prop="e03" />
        <el-table-column label="扩展字段4-预留" align="center" prop="e04" />
        <el-table-column label="扩展字段5-预留时间" align="center" prop="e05" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.e05, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="扩展字段6-预留金额" align="center" prop="e06" />
        <el-table-column label="扩展字段7-预留数字" align="center" prop="e07" />
        <el-table-column label="扩展字段8-预留文本" align="center" prop="e08" />
        <el-table-column label="扩展字段9-预留布尔值" align="center" prop="e09" />
        <el-table-column label="扩展字段10-预留编码" align="center" prop="e10" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['natdss:natdssB04MedicalRecordFrontSheetNonTcmSupplement:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['natdss:natdssB04MedicalRecordFrontSheetNonTcmSupplement:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改B04非中医院-补充信息（其他手术+费用+扩展信息）对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="natdssB04MedicalRecordFrontSheetNonTcmSupplementFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="其他手术操作编码1" prop="c35x01c">
          <el-input v-model="form.c35x01c" placeholder="请输入其他手术操作编码1" />
        </el-form-item>
        <el-form-item label="其他手术操作名称1" prop="c36x01n">
          <el-input v-model="form.c36x01n" placeholder="请输入其他手术操作名称1" />
        </el-form-item>
        <el-form-item label="其他手术操作日期1" prop="c37x01">
          <el-date-picker clearable
            v-model="form.c37x01"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期1">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别1" prop="c38x01">
          <el-input v-model="form.c38x01" placeholder="请输入其他手术操作级别1" />
        </el-form-item>
        <el-form-item label="其他手术操作术者1" prop="c39x01">
          <el-input v-model="form.c39x01" placeholder="请输入其他手术操作术者1" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助1" prop="c40x01">
          <el-input v-model="form.c40x01" placeholder="请输入其他手术操作Ⅰ助1" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助1" prop="c41x01">
          <el-input v-model="form.c41x01" placeholder="请输入其他手术操作Ⅱ助1" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级1" prop="c42x01c">
          <el-input v-model="form.c42x01c" placeholder="请输入其他手术操作切口愈合等级1" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式1" prop="c43x01c">
          <el-input v-model="form.c43x01c" placeholder="请输入其他手术操作麻醉方式1" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师1" prop="c44x01">
          <el-input v-model="form.c44x01" placeholder="请输入其他手术操作麻醉医师1" />
        </el-form-item>
        <el-form-item label="其他手术操作编码2" prop="c35x02c">
          <el-input v-model="form.c35x02c" placeholder="请输入其他手术操作编码2" />
        </el-form-item>
        <el-form-item label="其他手术操作名称2" prop="c36x02n">
          <el-input v-model="form.c36x02n" placeholder="请输入其他手术操作名称2" />
        </el-form-item>
        <el-form-item label="其他手术操作日期2" prop="c37x02">
          <el-date-picker clearable
            v-model="form.c37x02"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期2">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别2" prop="c38x02">
          <el-input v-model="form.c38x02" placeholder="请输入其他手术操作级别2" />
        </el-form-item>
        <el-form-item label="其他手术操作术者2" prop="c39x02">
          <el-input v-model="form.c39x02" placeholder="请输入其他手术操作术者2" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助2" prop="c40x02">
          <el-input v-model="form.c40x02" placeholder="请输入其他手术操作Ⅰ助2" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助2" prop="c41x02">
          <el-input v-model="form.c41x02" placeholder="请输入其他手术操作Ⅱ助2" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级2" prop="c42x02c">
          <el-input v-model="form.c42x02c" placeholder="请输入其他手术操作切口愈合等级2" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式2" prop="c43x02c">
          <el-input v-model="form.c43x02c" placeholder="请输入其他手术操作麻醉方式2" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师2" prop="c44x02">
          <el-input v-model="form.c44x02" placeholder="请输入其他手术操作麻醉医师2" />
        </el-form-item>
        <el-form-item label="其他手术操作编码3" prop="c35x03c">
          <el-input v-model="form.c35x03c" placeholder="请输入其他手术操作编码3" />
        </el-form-item>
        <el-form-item label="其他手术操作名称3" prop="c36x03n">
          <el-input v-model="form.c36x03n" placeholder="请输入其他手术操作名称3" />
        </el-form-item>
        <el-form-item label="其他手术操作日期3" prop="c37x03">
          <el-date-picker clearable
            v-model="form.c37x03"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期3">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别3" prop="c38x03">
          <el-input v-model="form.c38x03" placeholder="请输入其他手术操作级别3" />
        </el-form-item>
        <el-form-item label="其他手术操作术者3" prop="c39x03">
          <el-input v-model="form.c39x03" placeholder="请输入其他手术操作术者3" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助3" prop="c40x03">
          <el-input v-model="form.c40x03" placeholder="请输入其他手术操作Ⅰ助3" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助3" prop="c41x03">
          <el-input v-model="form.c41x03" placeholder="请输入其他手术操作Ⅱ助3" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级3" prop="c42x03c">
          <el-input v-model="form.c42x03c" placeholder="请输入其他手术操作切口愈合等级3" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式3" prop="c43x03c">
          <el-input v-model="form.c43x03c" placeholder="请输入其他手术操作麻醉方式3" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师3" prop="c44x03">
          <el-input v-model="form.c44x03" placeholder="请输入其他手术操作麻醉医师3" />
        </el-form-item>
        <el-form-item label="其他手术操作编码4" prop="c35x04c">
          <el-input v-model="form.c35x04c" placeholder="请输入其他手术操作编码4" />
        </el-form-item>
        <el-form-item label="其他手术操作名称4" prop="c36x04n">
          <el-input v-model="form.c36x04n" placeholder="请输入其他手术操作名称4" />
        </el-form-item>
        <el-form-item label="其他手术操作日期4" prop="c37x04">
          <el-date-picker clearable
            v-model="form.c37x04"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期4">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别4" prop="c38x04">
          <el-input v-model="form.c38x04" placeholder="请输入其他手术操作级别4" />
        </el-form-item>
        <el-form-item label="其他手术操作术者4" prop="c39x04">
          <el-input v-model="form.c39x04" placeholder="请输入其他手术操作术者4" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助4" prop="c40x04">
          <el-input v-model="form.c40x04" placeholder="请输入其他手术操作Ⅰ助4" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助4" prop="c41x04">
          <el-input v-model="form.c41x04" placeholder="请输入其他手术操作Ⅱ助4" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级4" prop="c42x04c">
          <el-input v-model="form.c42x04c" placeholder="请输入其他手术操作切口愈合等级4" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式4" prop="c43x04c">
          <el-input v-model="form.c43x04c" placeholder="请输入其他手术操作麻醉方式4" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师4" prop="c44x04">
          <el-input v-model="form.c44x04" placeholder="请输入其他手术操作麻醉医师4" />
        </el-form-item>
        <el-form-item label="其他手术操作编码5" prop="c35x05c">
          <el-input v-model="form.c35x05c" placeholder="请输入其他手术操作编码5" />
        </el-form-item>
        <el-form-item label="其他手术操作名称5" prop="c36x05n">
          <el-input v-model="form.c36x05n" placeholder="请输入其他手术操作名称5" />
        </el-form-item>
        <el-form-item label="其他手术操作日期5" prop="c37x05">
          <el-date-picker clearable
            v-model="form.c37x05"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期5">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别5" prop="c38x05">
          <el-input v-model="form.c38x05" placeholder="请输入其他手术操作级别5" />
        </el-form-item>
        <el-form-item label="其他手术操作术者5" prop="c39x05">
          <el-input v-model="form.c39x05" placeholder="请输入其他手术操作术者5" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助5" prop="c40x05">
          <el-input v-model="form.c40x05" placeholder="请输入其他手术操作Ⅰ助5" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助5" prop="c41x05">
          <el-input v-model="form.c41x05" placeholder="请输入其他手术操作Ⅱ助5" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级5" prop="c42x05c">
          <el-input v-model="form.c42x05c" placeholder="请输入其他手术操作切口愈合等级5" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式5" prop="c43x05c">
          <el-input v-model="form.c43x05c" placeholder="请输入其他手术操作麻醉方式5" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师5" prop="c44x05">
          <el-input v-model="form.c44x05" placeholder="请输入其他手术操作麻醉医师5" />
        </el-form-item>
        <el-form-item label="其他手术操作编码6" prop="c35x06c">
          <el-input v-model="form.c35x06c" placeholder="请输入其他手术操作编码6" />
        </el-form-item>
        <el-form-item label="其他手术操作名称6" prop="c36x06n">
          <el-input v-model="form.c36x06n" placeholder="请输入其他手术操作名称6" />
        </el-form-item>
        <el-form-item label="其他手术操作日期6" prop="c37x06">
          <el-date-picker clearable
            v-model="form.c37x06"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期6">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别6" prop="c38x06">
          <el-input v-model="form.c38x06" placeholder="请输入其他手术操作级别6" />
        </el-form-item>
        <el-form-item label="其他手术操作术者6" prop="c39x06">
          <el-input v-model="form.c39x06" placeholder="请输入其他手术操作术者6" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助6" prop="c40x06">
          <el-input v-model="form.c40x06" placeholder="请输入其他手术操作Ⅰ助6" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助6" prop="c41x06">
          <el-input v-model="form.c41x06" placeholder="请输入其他手术操作Ⅱ助6" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级6" prop="c42x06c">
          <el-input v-model="form.c42x06c" placeholder="请输入其他手术操作切口愈合等级6" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式6" prop="c43x06c">
          <el-input v-model="form.c43x06c" placeholder="请输入其他手术操作麻醉方式6" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师6" prop="c44x06">
          <el-input v-model="form.c44x06" placeholder="请输入其他手术操作麻醉医师6" />
        </el-form-item>
        <el-form-item label="其他手术操作编码7" prop="c35x07c">
          <el-input v-model="form.c35x07c" placeholder="请输入其他手术操作编码7" />
        </el-form-item>
        <el-form-item label="其他手术操作名称7" prop="c36x07n">
          <el-input v-model="form.c36x07n" placeholder="请输入其他手术操作名称7" />
        </el-form-item>
        <el-form-item label="其他手术操作日期7" prop="c37x07">
          <el-date-picker clearable
            v-model="form.c37x07"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期7">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别7" prop="c38x07">
          <el-input v-model="form.c38x07" placeholder="请输入其他手术操作级别7" />
        </el-form-item>
        <el-form-item label="其他手术操作术者7" prop="c39x07">
          <el-input v-model="form.c39x07" placeholder="请输入其他手术操作术者7" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助7" prop="c40x07">
          <el-input v-model="form.c40x07" placeholder="请输入其他手术操作Ⅰ助7" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助7" prop="c41x07">
          <el-input v-model="form.c41x07" placeholder="请输入其他手术操作Ⅱ助7" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级7" prop="c42x07c">
          <el-input v-model="form.c42x07c" placeholder="请输入其他手术操作切口愈合等级7" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式7" prop="c43x07c">
          <el-input v-model="form.c43x07c" placeholder="请输入其他手术操作麻醉方式7" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师7" prop="c44x07">
          <el-input v-model="form.c44x07" placeholder="请输入其他手术操作麻醉医师7" />
        </el-form-item>
        <el-form-item label="其他手术操作编码8" prop="c35x08c">
          <el-input v-model="form.c35x08c" placeholder="请输入其他手术操作编码8" />
        </el-form-item>
        <el-form-item label="其他手术操作名称8" prop="c36x08n">
          <el-input v-model="form.c36x08n" placeholder="请输入其他手术操作名称8" />
        </el-form-item>
        <el-form-item label="其他手术操作日期8" prop="c37x08">
          <el-date-picker clearable
            v-model="form.c37x08"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期8">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别8" prop="c38x08">
          <el-input v-model="form.c38x08" placeholder="请输入其他手术操作级别8" />
        </el-form-item>
        <el-form-item label="其他手术操作术者8" prop="c39x08">
          <el-input v-model="form.c39x08" placeholder="请输入其他手术操作术者8" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助8" prop="c40x08">
          <el-input v-model="form.c40x08" placeholder="请输入其他手术操作Ⅰ助8" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助8" prop="c41x08">
          <el-input v-model="form.c41x08" placeholder="请输入其他手术操作Ⅱ助8" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级8" prop="c42x08c">
          <el-input v-model="form.c42x08c" placeholder="请输入其他手术操作切口愈合等级8" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式8" prop="c43x08c">
          <el-input v-model="form.c43x08c" placeholder="请输入其他手术操作麻醉方式8" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师8" prop="c44x08">
          <el-input v-model="form.c44x08" placeholder="请输入其他手术操作麻醉医师8" />
        </el-form-item>
        <el-form-item label="其他手术操作编码9" prop="c35x09c">
          <el-input v-model="form.c35x09c" placeholder="请输入其他手术操作编码9" />
        </el-form-item>
        <el-form-item label="其他手术操作名称9" prop="c36x09n">
          <el-input v-model="form.c36x09n" placeholder="请输入其他手术操作名称9" />
        </el-form-item>
        <el-form-item label="其他手术操作日期9" prop="c37x09">
          <el-date-picker clearable
            v-model="form.c37x09"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期9">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别9" prop="c38x09">
          <el-input v-model="form.c38x09" placeholder="请输入其他手术操作级别9" />
        </el-form-item>
        <el-form-item label="其他手术操作术者9" prop="c39x09">
          <el-input v-model="form.c39x09" placeholder="请输入其他手术操作术者9" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助9" prop="c40x09">
          <el-input v-model="form.c40x09" placeholder="请输入其他手术操作Ⅰ助9" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助9" prop="c41x09">
          <el-input v-model="form.c41x09" placeholder="请输入其他手术操作Ⅱ助9" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级9" prop="c42x09c">
          <el-input v-model="form.c42x09c" placeholder="请输入其他手术操作切口愈合等级9" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式9" prop="c43x09c">
          <el-input v-model="form.c43x09c" placeholder="请输入其他手术操作麻醉方式9" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师9" prop="c44x09">
          <el-input v-model="form.c44x09" placeholder="请输入其他手术操作麻醉医师9" />
        </el-form-item>
        <el-form-item label="其他手术操作编码10" prop="c35x10c">
          <el-input v-model="form.c35x10c" placeholder="请输入其他手术操作编码10" />
        </el-form-item>
        <el-form-item label="其他手术操作名称10" prop="c36x10n">
          <el-input v-model="form.c36x10n" placeholder="请输入其他手术操作名称10" />
        </el-form-item>
        <el-form-item label="其他手术操作日期10" prop="c37x10">
          <el-date-picker clearable
            v-model="form.c37x10"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期10">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别10" prop="c38x10">
          <el-input v-model="form.c38x10" placeholder="请输入其他手术操作级别10" />
        </el-form-item>
        <el-form-item label="其他手术操作术者10" prop="c39x10">
          <el-input v-model="form.c39x10" placeholder="请输入其他手术操作术者10" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助10" prop="c40x10">
          <el-input v-model="form.c40x10" placeholder="请输入其他手术操作Ⅰ助10" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助10" prop="c41x10">
          <el-input v-model="form.c41x10" placeholder="请输入其他手术操作Ⅱ助10" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级10" prop="c42x10c">
          <el-input v-model="form.c42x10c" placeholder="请输入其他手术操作切口愈合等级10" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式10" prop="c43x10c">
          <el-input v-model="form.c43x10c" placeholder="请输入其他手术操作麻醉方式10" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师10" prop="c44x10">
          <el-input v-model="form.c44x10" placeholder="请输入其他手术操作麻醉医师10" />
        </el-form-item>
        <el-form-item label="其他手术操作编码11" prop="c35x11c">
          <el-input v-model="form.c35x11c" placeholder="请输入其他手术操作编码11" />
        </el-form-item>
        <el-form-item label="其他手术操作名称11" prop="c36x11n">
          <el-input v-model="form.c36x11n" placeholder="请输入其他手术操作名称11" />
        </el-form-item>
        <el-form-item label="其他手术操作日期11" prop="c37x11">
          <el-date-picker clearable
            v-model="form.c37x11"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期11">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别11" prop="c38x11">
          <el-input v-model="form.c38x11" placeholder="请输入其他手术操作级别11" />
        </el-form-item>
        <el-form-item label="其他手术操作术者11" prop="c39x11">
          <el-input v-model="form.c39x11" placeholder="请输入其他手术操作术者11" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助11" prop="c40x11">
          <el-input v-model="form.c40x11" placeholder="请输入其他手术操作Ⅰ助11" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助11" prop="c41x11">
          <el-input v-model="form.c41x11" placeholder="请输入其他手术操作Ⅱ助11" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级11" prop="c42x11c">
          <el-input v-model="form.c42x11c" placeholder="请输入其他手术操作切口愈合等级11" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式11" prop="c43x11c">
          <el-input v-model="form.c43x11c" placeholder="请输入其他手术操作麻醉方式11" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师11" prop="c44x11">
          <el-input v-model="form.c44x11" placeholder="请输入其他手术操作麻醉医师11" />
        </el-form-item>
        <el-form-item label="其他手术操作编码12" prop="c35x12c">
          <el-input v-model="form.c35x12c" placeholder="请输入其他手术操作编码12" />
        </el-form-item>
        <el-form-item label="其他手术操作名称12" prop="c36x12n">
          <el-input v-model="form.c36x12n" placeholder="请输入其他手术操作名称12" />
        </el-form-item>
        <el-form-item label="其他手术操作日期12" prop="c37x12">
          <el-date-picker clearable
            v-model="form.c37x12"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期12">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别12" prop="c38x12">
          <el-input v-model="form.c38x12" placeholder="请输入其他手术操作级别12" />
        </el-form-item>
        <el-form-item label="其他手术操作术者12" prop="c39x12">
          <el-input v-model="form.c39x12" placeholder="请输入其他手术操作术者12" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助12" prop="c40x12">
          <el-input v-model="form.c40x12" placeholder="请输入其他手术操作Ⅰ助12" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助12" prop="c41x12">
          <el-input v-model="form.c41x12" placeholder="请输入其他手术操作Ⅱ助12" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级12" prop="c42x12c">
          <el-input v-model="form.c42x12c" placeholder="请输入其他手术操作切口愈合等级12" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式12" prop="c43x12c">
          <el-input v-model="form.c43x12c" placeholder="请输入其他手术操作麻醉方式12" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师12" prop="c44x12">
          <el-input v-model="form.c44x12" placeholder="请输入其他手术操作麻醉医师12" />
        </el-form-item>
        <el-form-item label="其他手术操作编码13" prop="c35x13c">
          <el-input v-model="form.c35x13c" placeholder="请输入其他手术操作编码13" />
        </el-form-item>
        <el-form-item label="其他手术操作名称13" prop="c36x13n">
          <el-input v-model="form.c36x13n" placeholder="请输入其他手术操作名称13" />
        </el-form-item>
        <el-form-item label="其他手术操作日期13" prop="c37x13">
          <el-date-picker clearable
            v-model="form.c37x13"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期13">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别13" prop="c38x13">
          <el-input v-model="form.c38x13" placeholder="请输入其他手术操作级别13" />
        </el-form-item>
        <el-form-item label="其他手术操作术者13" prop="c39x13">
          <el-input v-model="form.c39x13" placeholder="请输入其他手术操作术者13" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助13" prop="c40x13">
          <el-input v-model="form.c40x13" placeholder="请输入其他手术操作Ⅰ助13" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助13" prop="c41x13">
          <el-input v-model="form.c41x13" placeholder="请输入其他手术操作Ⅱ助13" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级13" prop="c42x13c">
          <el-input v-model="form.c42x13c" placeholder="请输入其他手术操作切口愈合等级13" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式13" prop="c43x13c">
          <el-input v-model="form.c43x13c" placeholder="请输入其他手术操作麻醉方式13" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师13" prop="c44x13">
          <el-input v-model="form.c44x13" placeholder="请输入其他手术操作麻醉医师13" />
        </el-form-item>
        <el-form-item label="其他手术操作编码14" prop="c35x14c">
          <el-input v-model="form.c35x14c" placeholder="请输入其他手术操作编码14" />
        </el-form-item>
        <el-form-item label="其他手术操作名称14" prop="c36x14n">
          <el-input v-model="form.c36x14n" placeholder="请输入其他手术操作名称14" />
        </el-form-item>
        <el-form-item label="其他手术操作日期14" prop="c37x14">
          <el-date-picker clearable
            v-model="form.c37x14"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期14">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别14" prop="c38x14">
          <el-input v-model="form.c38x14" placeholder="请输入其他手术操作级别14" />
        </el-form-item>
        <el-form-item label="其他手术操作术者14" prop="c39x14">
          <el-input v-model="form.c39x14" placeholder="请输入其他手术操作术者14" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助14" prop="c40x14">
          <el-input v-model="form.c40x14" placeholder="请输入其他手术操作Ⅰ助14" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助14" prop="c41x14">
          <el-input v-model="form.c41x14" placeholder="请输入其他手术操作Ⅱ助14" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级14" prop="c42x14c">
          <el-input v-model="form.c42x14c" placeholder="请输入其他手术操作切口愈合等级14" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式14" prop="c43x14c">
          <el-input v-model="form.c43x14c" placeholder="请输入其他手术操作麻醉方式14" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师14" prop="c44x14">
          <el-input v-model="form.c44x14" placeholder="请输入其他手术操作麻醉医师14" />
        </el-form-item>
        <el-form-item label="其他手术操作编码15" prop="c35x15c">
          <el-input v-model="form.c35x15c" placeholder="请输入其他手术操作编码15" />
        </el-form-item>
        <el-form-item label="其他手术操作名称15" prop="c36x15n">
          <el-input v-model="form.c36x15n" placeholder="请输入其他手术操作名称15" />
        </el-form-item>
        <el-form-item label="其他手术操作日期15" prop="c37x15">
          <el-date-picker clearable
            v-model="form.c37x15"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期15">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别15" prop="c38x15">
          <el-input v-model="form.c38x15" placeholder="请输入其他手术操作级别15" />
        </el-form-item>
        <el-form-item label="其他手术操作术者15" prop="c39x15">
          <el-input v-model="form.c39x15" placeholder="请输入其他手术操作术者15" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助15" prop="c40x15">
          <el-input v-model="form.c40x15" placeholder="请输入其他手术操作Ⅰ助15" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助15" prop="c41x15">
          <el-input v-model="form.c41x15" placeholder="请输入其他手术操作Ⅱ助15" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级15" prop="c42x15c">
          <el-input v-model="form.c42x15c" placeholder="请输入其他手术操作切口愈合等级15" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式15" prop="c43x15c">
          <el-input v-model="form.c43x15c" placeholder="请输入其他手术操作麻醉方式15" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师15" prop="c44x15">
          <el-input v-model="form.c44x15" placeholder="请输入其他手术操作麻醉医师15" />
        </el-form-item>
        <el-form-item label="其他手术操作编码16" prop="c35x16c">
          <el-input v-model="form.c35x16c" placeholder="请输入其他手术操作编码16" />
        </el-form-item>
        <el-form-item label="其他手术操作名称16" prop="c36x16n">
          <el-input v-model="form.c36x16n" placeholder="请输入其他手术操作名称16" />
        </el-form-item>
        <el-form-item label="其他手术操作日期16" prop="c37x16">
          <el-date-picker clearable
            v-model="form.c37x16"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期16">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别16" prop="c38x16">
          <el-input v-model="form.c38x16" placeholder="请输入其他手术操作级别16" />
        </el-form-item>
        <el-form-item label="其他手术操作术者16" prop="c39x16">
          <el-input v-model="form.c39x16" placeholder="请输入其他手术操作术者16" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助16" prop="c40x16">
          <el-input v-model="form.c40x16" placeholder="请输入其他手术操作Ⅰ助16" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助16" prop="c41x16">
          <el-input v-model="form.c41x16" placeholder="请输入其他手术操作Ⅱ助16" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级16" prop="c42x16c">
          <el-input v-model="form.c42x16c" placeholder="请输入其他手术操作切口愈合等级16" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式16" prop="c43x16c">
          <el-input v-model="form.c43x16c" placeholder="请输入其他手术操作麻醉方式16" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师16" prop="c44x16">
          <el-input v-model="form.c44x16" placeholder="请输入其他手术操作麻醉医师16" />
        </el-form-item>
        <el-form-item label="其他手术操作编码17" prop="c35x17c">
          <el-input v-model="form.c35x17c" placeholder="请输入其他手术操作编码17" />
        </el-form-item>
        <el-form-item label="其他手术操作名称17" prop="c36x17n">
          <el-input v-model="form.c36x17n" placeholder="请输入其他手术操作名称17" />
        </el-form-item>
        <el-form-item label="其他手术操作日期17" prop="c37x17">
          <el-date-picker clearable
            v-model="form.c37x17"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期17">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别17" prop="c38x17">
          <el-input v-model="form.c38x17" placeholder="请输入其他手术操作级别17" />
        </el-form-item>
        <el-form-item label="其他手术操作术者17" prop="c39x17">
          <el-input v-model="form.c39x17" placeholder="请输入其他手术操作术者17" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助17" prop="c40x17">
          <el-input v-model="form.c40x17" placeholder="请输入其他手术操作Ⅰ助17" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助17" prop="c41x17">
          <el-input v-model="form.c41x17" placeholder="请输入其他手术操作Ⅱ助17" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级17" prop="c42x17c">
          <el-input v-model="form.c42x17c" placeholder="请输入其他手术操作切口愈合等级17" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式17" prop="c43x17c">
          <el-input v-model="form.c43x17c" placeholder="请输入其他手术操作麻醉方式17" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师17" prop="c44x17">
          <el-input v-model="form.c44x17" placeholder="请输入其他手术操作麻醉医师17" />
        </el-form-item>
        <el-form-item label="其他手术操作编码18" prop="c35x18c">
          <el-input v-model="form.c35x18c" placeholder="请输入其他手术操作编码18" />
        </el-form-item>
        <el-form-item label="其他手术操作名称18" prop="c36x18n">
          <el-input v-model="form.c36x18n" placeholder="请输入其他手术操作名称18" />
        </el-form-item>
        <el-form-item label="其他手术操作日期18" prop="c37x18">
          <el-date-picker clearable
            v-model="form.c37x18"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期18">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别18" prop="c38x18">
          <el-input v-model="form.c38x18" placeholder="请输入其他手术操作级别18" />
        </el-form-item>
        <el-form-item label="其他手术操作术者18" prop="c39x18">
          <el-input v-model="form.c39x18" placeholder="请输入其他手术操作术者18" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助18" prop="c40x18">
          <el-input v-model="form.c40x18" placeholder="请输入其他手术操作Ⅰ助18" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助18" prop="c41x18">
          <el-input v-model="form.c41x18" placeholder="请输入其他手术操作Ⅱ助18" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级18" prop="c42x18c">
          <el-input v-model="form.c42x18c" placeholder="请输入其他手术操作切口愈合等级18" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式18" prop="c43x18c">
          <el-input v-model="form.c43x18c" placeholder="请输入其他手术操作麻醉方式18" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师18" prop="c44x18">
          <el-input v-model="form.c44x18" placeholder="请输入其他手术操作麻醉医师18" />
        </el-form-item>
        <el-form-item label="其他手术操作编码19" prop="c35x19c">
          <el-input v-model="form.c35x19c" placeholder="请输入其他手术操作编码19" />
        </el-form-item>
        <el-form-item label="其他手术操作名称19" prop="c36x19n">
          <el-input v-model="form.c36x19n" placeholder="请输入其他手术操作名称19" />
        </el-form-item>
        <el-form-item label="其他手术操作日期19" prop="c37x19">
          <el-date-picker clearable
            v-model="form.c37x19"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期19">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别19" prop="c38x19">
          <el-input v-model="form.c38x19" placeholder="请输入其他手术操作级别19" />
        </el-form-item>
        <el-form-item label="其他手术操作术者19" prop="c39x19">
          <el-input v-model="form.c39x19" placeholder="请输入其他手术操作术者19" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助19" prop="c40x19">
          <el-input v-model="form.c40x19" placeholder="请输入其他手术操作Ⅰ助19" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助19" prop="c41x19">
          <el-input v-model="form.c41x19" placeholder="请输入其他手术操作Ⅱ助19" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级19" prop="c42x19c">
          <el-input v-model="form.c42x19c" placeholder="请输入其他手术操作切口愈合等级19" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式19" prop="c43x19c">
          <el-input v-model="form.c43x19c" placeholder="请输入其他手术操作麻醉方式19" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师19" prop="c44x19">
          <el-input v-model="form.c44x19" placeholder="请输入其他手术操作麻醉医师19" />
        </el-form-item>
        <el-form-item label="其他手术操作编码20" prop="c35x20c">
          <el-input v-model="form.c35x20c" placeholder="请输入其他手术操作编码20" />
        </el-form-item>
        <el-form-item label="其他手术操作名称20" prop="c36x20n">
          <el-input v-model="form.c36x20n" placeholder="请输入其他手术操作名称20" />
        </el-form-item>
        <el-form-item label="其他手术操作日期20" prop="c37x20">
          <el-date-picker clearable
            v-model="form.c37x20"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期20">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别20" prop="c38x20">
          <el-input v-model="form.c38x20" placeholder="请输入其他手术操作级别20" />
        </el-form-item>
        <el-form-item label="其他手术操作术者20" prop="c39x20">
          <el-input v-model="form.c39x20" placeholder="请输入其他手术操作术者20" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助20" prop="c40x20">
          <el-input v-model="form.c40x20" placeholder="请输入其他手术操作Ⅰ助20" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助20" prop="c41x20">
          <el-input v-model="form.c41x20" placeholder="请输入其他手术操作Ⅱ助20" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级20" prop="c42x20c">
          <el-input v-model="form.c42x20c" placeholder="请输入其他手术操作切口愈合等级20" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式20" prop="c43x20c">
          <el-input v-model="form.c43x20c" placeholder="请输入其他手术操作麻醉方式20" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师20" prop="c44x20">
          <el-input v-model="form.c44x20" placeholder="请输入其他手术操作麻醉医师20" />
        </el-form-item>
        <el-form-item label="其他手术操作编码21" prop="c35x21c">
          <el-input v-model="form.c35x21c" placeholder="请输入其他手术操作编码21" />
        </el-form-item>
        <el-form-item label="其他手术操作名称21" prop="c36x21n">
          <el-input v-model="form.c36x21n" placeholder="请输入其他手术操作名称21" />
        </el-form-item>
        <el-form-item label="其他手术操作日期21" prop="c37x21">
          <el-date-picker clearable
            v-model="form.c37x21"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期21">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别21" prop="c38x21">
          <el-input v-model="form.c38x21" placeholder="请输入其他手术操作级别21" />
        </el-form-item>
        <el-form-item label="其他手术操作术者21" prop="c39x21">
          <el-input v-model="form.c39x21" placeholder="请输入其他手术操作术者21" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助21" prop="c40x21">
          <el-input v-model="form.c40x21" placeholder="请输入其他手术操作Ⅰ助21" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助21" prop="c41x21">
          <el-input v-model="form.c41x21" placeholder="请输入其他手术操作Ⅱ助21" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级21" prop="c42x21c">
          <el-input v-model="form.c42x21c" placeholder="请输入其他手术操作切口愈合等级21" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式21" prop="c43x21c">
          <el-input v-model="form.c43x21c" placeholder="请输入其他手术操作麻醉方式21" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师21" prop="c44x21">
          <el-input v-model="form.c44x21" placeholder="请输入其他手术操作麻醉医师21" />
        </el-form-item>
        <el-form-item label="其他手术操作编码22" prop="c35x22c">
          <el-input v-model="form.c35x22c" placeholder="请输入其他手术操作编码22" />
        </el-form-item>
        <el-form-item label="其他手术操作名称22" prop="c36x22n">
          <el-input v-model="form.c36x22n" placeholder="请输入其他手术操作名称22" />
        </el-form-item>
        <el-form-item label="其他手术操作日期22" prop="c37x22">
          <el-date-picker clearable
            v-model="form.c37x22"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期22">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别22" prop="c38x22">
          <el-input v-model="form.c38x22" placeholder="请输入其他手术操作级别22" />
        </el-form-item>
        <el-form-item label="其他手术操作术者22" prop="c39x22">
          <el-input v-model="form.c39x22" placeholder="请输入其他手术操作术者22" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助22" prop="c40x22">
          <el-input v-model="form.c40x22" placeholder="请输入其他手术操作Ⅰ助22" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助22" prop="c41x22">
          <el-input v-model="form.c41x22" placeholder="请输入其他手术操作Ⅱ助22" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级22" prop="c42x22c">
          <el-input v-model="form.c42x22c" placeholder="请输入其他手术操作切口愈合等级22" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式22" prop="c43x22c">
          <el-input v-model="form.c43x22c" placeholder="请输入其他手术操作麻醉方式22" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师22" prop="c44x22">
          <el-input v-model="form.c44x22" placeholder="请输入其他手术操作麻醉医师22" />
        </el-form-item>
        <el-form-item label="其他手术操作编码23" prop="c35x23c">
          <el-input v-model="form.c35x23c" placeholder="请输入其他手术操作编码23" />
        </el-form-item>
        <el-form-item label="其他手术操作名称23" prop="c36x23n">
          <el-input v-model="form.c36x23n" placeholder="请输入其他手术操作名称23" />
        </el-form-item>
        <el-form-item label="其他手术操作日期23" prop="c37x23">
          <el-date-picker clearable
            v-model="form.c37x23"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期23">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别23" prop="c38x23">
          <el-input v-model="form.c38x23" placeholder="请输入其他手术操作级别23" />
        </el-form-item>
        <el-form-item label="其他手术操作术者23" prop="c39x23">
          <el-input v-model="form.c39x23" placeholder="请输入其他手术操作术者23" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助23" prop="c40x23">
          <el-input v-model="form.c40x23" placeholder="请输入其他手术操作Ⅰ助23" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助23" prop="c41x23">
          <el-input v-model="form.c41x23" placeholder="请输入其他手术操作Ⅱ助23" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级23" prop="c42x23c">
          <el-input v-model="form.c42x23c" placeholder="请输入其他手术操作切口愈合等级23" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式23" prop="c43x23c">
          <el-input v-model="form.c43x23c" placeholder="请输入其他手术操作麻醉方式23" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师23" prop="c44x23">
          <el-input v-model="form.c44x23" placeholder="请输入其他手术操作麻醉医师23" />
        </el-form-item>
        <el-form-item label="其他手术操作编码24" prop="c35x24c">
          <el-input v-model="form.c35x24c" placeholder="请输入其他手术操作编码24" />
        </el-form-item>
        <el-form-item label="其他手术操作名称24" prop="c36x24n">
          <el-input v-model="form.c36x24n" placeholder="请输入其他手术操作名称24" />
        </el-form-item>
        <el-form-item label="其他手术操作日期24" prop="c37x24">
          <el-date-picker clearable
            v-model="form.c37x24"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期24">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别24" prop="c38x24">
          <el-input v-model="form.c38x24" placeholder="请输入其他手术操作级别24" />
        </el-form-item>
        <el-form-item label="其他手术操作术者24" prop="c39x24">
          <el-input v-model="form.c39x24" placeholder="请输入其他手术操作术者24" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助24" prop="c40x24">
          <el-input v-model="form.c40x24" placeholder="请输入其他手术操作Ⅰ助24" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助24" prop="c41x24">
          <el-input v-model="form.c41x24" placeholder="请输入其他手术操作Ⅱ助24" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级24" prop="c42x24c">
          <el-input v-model="form.c42x24c" placeholder="请输入其他手术操作切口愈合等级24" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式24" prop="c43x24c">
          <el-input v-model="form.c43x24c" placeholder="请输入其他手术操作麻醉方式24" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师24" prop="c44x24">
          <el-input v-model="form.c44x24" placeholder="请输入其他手术操作麻醉医师24" />
        </el-form-item>
        <el-form-item label="其他手术操作编码25" prop="c35x25c">
          <el-input v-model="form.c35x25c" placeholder="请输入其他手术操作编码25" />
        </el-form-item>
        <el-form-item label="其他手术操作名称25" prop="c36x25n">
          <el-input v-model="form.c36x25n" placeholder="请输入其他手术操作名称25" />
        </el-form-item>
        <el-form-item label="其他手术操作日期25" prop="c37x25">
          <el-date-picker clearable
            v-model="form.c37x25"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期25">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别25" prop="c38x25">
          <el-input v-model="form.c38x25" placeholder="请输入其他手术操作级别25" />
        </el-form-item>
        <el-form-item label="其他手术操作术者25" prop="c39x25">
          <el-input v-model="form.c39x25" placeholder="请输入其他手术操作术者25" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助25" prop="c40x25">
          <el-input v-model="form.c40x25" placeholder="请输入其他手术操作Ⅰ助25" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助25" prop="c41x25">
          <el-input v-model="form.c41x25" placeholder="请输入其他手术操作Ⅱ助25" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级25" prop="c42x25c">
          <el-input v-model="form.c42x25c" placeholder="请输入其他手术操作切口愈合等级25" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式25" prop="c43x25c">
          <el-input v-model="form.c43x25c" placeholder="请输入其他手术操作麻醉方式25" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师25" prop="c44x25">
          <el-input v-model="form.c44x25" placeholder="请输入其他手术操作麻醉医师25" />
        </el-form-item>
        <el-form-item label="其他手术操作编码26" prop="c35x26c">
          <el-input v-model="form.c35x26c" placeholder="请输入其他手术操作编码26" />
        </el-form-item>
        <el-form-item label="其他手术操作名称26" prop="c36x26n">
          <el-input v-model="form.c36x26n" placeholder="请输入其他手术操作名称26" />
        </el-form-item>
        <el-form-item label="其他手术操作日期26" prop="c37x26">
          <el-date-picker clearable
            v-model="form.c37x26"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期26">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别26" prop="c38x26">
          <el-input v-model="form.c38x26" placeholder="请输入其他手术操作级别26" />
        </el-form-item>
        <el-form-item label="其他手术操作术者26" prop="c39x26">
          <el-input v-model="form.c39x26" placeholder="请输入其他手术操作术者26" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助26" prop="c40x26">
          <el-input v-model="form.c40x26" placeholder="请输入其他手术操作Ⅰ助26" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助26" prop="c41x26">
          <el-input v-model="form.c41x26" placeholder="请输入其他手术操作Ⅱ助26" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级26" prop="c42x26c">
          <el-input v-model="form.c42x26c" placeholder="请输入其他手术操作切口愈合等级26" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式26" prop="c43x26c">
          <el-input v-model="form.c43x26c" placeholder="请输入其他手术操作麻醉方式26" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师26" prop="c44x26">
          <el-input v-model="form.c44x26" placeholder="请输入其他手术操作麻醉医师26" />
        </el-form-item>
        <el-form-item label="其他手术操作编码27" prop="c35x27c">
          <el-input v-model="form.c35x27c" placeholder="请输入其他手术操作编码27" />
        </el-form-item>
        <el-form-item label="其他手术操作名称27" prop="c36x27n">
          <el-input v-model="form.c36x27n" placeholder="请输入其他手术操作名称27" />
        </el-form-item>
        <el-form-item label="其他手术操作日期27" prop="c37x27">
          <el-date-picker clearable
            v-model="form.c37x27"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期27">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别27" prop="c38x27">
          <el-input v-model="form.c38x27" placeholder="请输入其他手术操作级别27" />
        </el-form-item>
        <el-form-item label="其他手术操作术者27" prop="c39x27">
          <el-input v-model="form.c39x27" placeholder="请输入其他手术操作术者27" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助27" prop="c40x27">
          <el-input v-model="form.c40x27" placeholder="请输入其他手术操作Ⅰ助27" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助27" prop="c41x27">
          <el-input v-model="form.c41x27" placeholder="请输入其他手术操作Ⅱ助27" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级27" prop="c42x27c">
          <el-input v-model="form.c42x27c" placeholder="请输入其他手术操作切口愈合等级27" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式27" prop="c43x27c">
          <el-input v-model="form.c43x27c" placeholder="请输入其他手术操作麻醉方式27" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师27" prop="c44x27">
          <el-input v-model="form.c44x27" placeholder="请输入其他手术操作麻醉医师27" />
        </el-form-item>
        <el-form-item label="其他手术操作编码28" prop="c35x28c">
          <el-input v-model="form.c35x28c" placeholder="请输入其他手术操作编码28" />
        </el-form-item>
        <el-form-item label="其他手术操作名称28" prop="c36x28n">
          <el-input v-model="form.c36x28n" placeholder="请输入其他手术操作名称28" />
        </el-form-item>
        <el-form-item label="其他手术操作日期28" prop="c37x28">
          <el-date-picker clearable
            v-model="form.c37x28"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期28">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别28" prop="c38x28">
          <el-input v-model="form.c38x28" placeholder="请输入其他手术操作级别28" />
        </el-form-item>
        <el-form-item label="其他手术操作术者28" prop="c39x28">
          <el-input v-model="form.c39x28" placeholder="请输入其他手术操作术者28" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助28" prop="c40x28">
          <el-input v-model="form.c40x28" placeholder="请输入其他手术操作Ⅰ助28" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助28" prop="c41x28">
          <el-input v-model="form.c41x28" placeholder="请输入其他手术操作Ⅱ助28" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级28" prop="c42x28c">
          <el-input v-model="form.c42x28c" placeholder="请输入其他手术操作切口愈合等级28" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式28" prop="c43x28c">
          <el-input v-model="form.c43x28c" placeholder="请输入其他手术操作麻醉方式28" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师28" prop="c44x28">
          <el-input v-model="form.c44x28" placeholder="请输入其他手术操作麻醉医师28" />
        </el-form-item>
        <el-form-item label="其他手术操作编码29" prop="c35x29c">
          <el-input v-model="form.c35x29c" placeholder="请输入其他手术操作编码29" />
        </el-form-item>
        <el-form-item label="其他手术操作名称29" prop="c36x29n">
          <el-input v-model="form.c36x29n" placeholder="请输入其他手术操作名称29" />
        </el-form-item>
        <el-form-item label="其他手术操作日期29" prop="c37x29">
          <el-date-picker clearable
            v-model="form.c37x29"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期29">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别29" prop="c38x29">
          <el-input v-model="form.c38x29" placeholder="请输入其他手术操作级别29" />
        </el-form-item>
        <el-form-item label="其他手术操作术者29" prop="c39x29">
          <el-input v-model="form.c39x29" placeholder="请输入其他手术操作术者29" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助29" prop="c40x29">
          <el-input v-model="form.c40x29" placeholder="请输入其他手术操作Ⅰ助29" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助29" prop="c41x29">
          <el-input v-model="form.c41x29" placeholder="请输入其他手术操作Ⅱ助29" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级29" prop="c42x29c">
          <el-input v-model="form.c42x29c" placeholder="请输入其他手术操作切口愈合等级29" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式29" prop="c43x29c">
          <el-input v-model="form.c43x29c" placeholder="请输入其他手术操作麻醉方式29" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师29" prop="c44x29">
          <el-input v-model="form.c44x29" placeholder="请输入其他手术操作麻醉医师29" />
        </el-form-item>
        <el-form-item label="其他手术操作编码30" prop="c35x30c">
          <el-input v-model="form.c35x30c" placeholder="请输入其他手术操作编码30" />
        </el-form-item>
        <el-form-item label="其他手术操作名称30" prop="c36x30n">
          <el-input v-model="form.c36x30n" placeholder="请输入其他手术操作名称30" />
        </el-form-item>
        <el-form-item label="其他手术操作日期30" prop="c37x30">
          <el-date-picker clearable
            v-model="form.c37x30"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期30">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别30" prop="c38x30">
          <el-input v-model="form.c38x30" placeholder="请输入其他手术操作级别30" />
        </el-form-item>
        <el-form-item label="其他手术操作术者30" prop="c39x30">
          <el-input v-model="form.c39x30" placeholder="请输入其他手术操作术者30" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助30" prop="c40x30">
          <el-input v-model="form.c40x30" placeholder="请输入其他手术操作Ⅰ助30" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助30" prop="c41x30">
          <el-input v-model="form.c41x30" placeholder="请输入其他手术操作Ⅱ助30" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级30" prop="c42x30c">
          <el-input v-model="form.c42x30c" placeholder="请输入其他手术操作切口愈合等级30" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式30" prop="c43x30c">
          <el-input v-model="form.c43x30c" placeholder="请输入其他手术操作麻醉方式30" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师30" prop="c44x30">
          <el-input v-model="form.c44x30" placeholder="请输入其他手术操作麻醉医师30" />
        </el-form-item>
        <el-form-item label="其他手术操作编码31" prop="c35x31c">
          <el-input v-model="form.c35x31c" placeholder="请输入其他手术操作编码31" />
        </el-form-item>
        <el-form-item label="其他手术操作名称31" prop="c36x31n">
          <el-input v-model="form.c36x31n" placeholder="请输入其他手术操作名称31" />
        </el-form-item>
        <el-form-item label="其他手术操作日期31" prop="c37x31">
          <el-date-picker clearable
            v-model="form.c37x31"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期31">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别31" prop="c38x31">
          <el-input v-model="form.c38x31" placeholder="请输入其他手术操作级别31" />
        </el-form-item>
        <el-form-item label="其他手术操作术者31" prop="c39x31">
          <el-input v-model="form.c39x31" placeholder="请输入其他手术操作术者31" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助31" prop="c40x31">
          <el-input v-model="form.c40x31" placeholder="请输入其他手术操作Ⅰ助31" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助31" prop="c41x31">
          <el-input v-model="form.c41x31" placeholder="请输入其他手术操作Ⅱ助31" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级31" prop="c42x31c">
          <el-input v-model="form.c42x31c" placeholder="请输入其他手术操作切口愈合等级31" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式31" prop="c43x31c">
          <el-input v-model="form.c43x31c" placeholder="请输入其他手术操作麻醉方式31" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师31" prop="c44x31">
          <el-input v-model="form.c44x31" placeholder="请输入其他手术操作麻醉医师31" />
        </el-form-item>
        <el-form-item label="其他手术操作编码32" prop="c35x32c">
          <el-input v-model="form.c35x32c" placeholder="请输入其他手术操作编码32" />
        </el-form-item>
        <el-form-item label="其他手术操作名称32" prop="c36x32n">
          <el-input v-model="form.c36x32n" placeholder="请输入其他手术操作名称32" />
        </el-form-item>
        <el-form-item label="其他手术操作日期32" prop="c37x32">
          <el-date-picker clearable
            v-model="form.c37x32"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期32">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别32" prop="c38x32">
          <el-input v-model="form.c38x32" placeholder="请输入其他手术操作级别32" />
        </el-form-item>
        <el-form-item label="其他手术操作术者32" prop="c39x32">
          <el-input v-model="form.c39x32" placeholder="请输入其他手术操作术者32" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助32" prop="c40x32">
          <el-input v-model="form.c40x32" placeholder="请输入其他手术操作Ⅰ助32" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助32" prop="c41x32">
          <el-input v-model="form.c41x32" placeholder="请输入其他手术操作Ⅱ助32" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级32" prop="c42x32c">
          <el-input v-model="form.c42x32c" placeholder="请输入其他手术操作切口愈合等级32" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式32" prop="c43x32c">
          <el-input v-model="form.c43x32c" placeholder="请输入其他手术操作麻醉方式32" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师32" prop="c44x32">
          <el-input v-model="form.c44x32" placeholder="请输入其他手术操作麻醉医师32" />
        </el-form-item>
        <el-form-item label="其他手术操作编码33" prop="c35x33c">
          <el-input v-model="form.c35x33c" placeholder="请输入其他手术操作编码33" />
        </el-form-item>
        <el-form-item label="其他手术操作名称33" prop="c36x33n">
          <el-input v-model="form.c36x33n" placeholder="请输入其他手术操作名称33" />
        </el-form-item>
        <el-form-item label="其他手术操作日期33" prop="c37x33">
          <el-date-picker clearable
            v-model="form.c37x33"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期33">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别33" prop="c38x33">
          <el-input v-model="form.c38x33" placeholder="请输入其他手术操作级别33" />
        </el-form-item>
        <el-form-item label="其他手术操作术者33" prop="c39x33">
          <el-input v-model="form.c39x33" placeholder="请输入其他手术操作术者33" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助33" prop="c40x33">
          <el-input v-model="form.c40x33" placeholder="请输入其他手术操作Ⅰ助33" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助33" prop="c41x33">
          <el-input v-model="form.c41x33" placeholder="请输入其他手术操作Ⅱ助33" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级33" prop="c42x33c">
          <el-input v-model="form.c42x33c" placeholder="请输入其他手术操作切口愈合等级33" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式33" prop="c43x33c">
          <el-input v-model="form.c43x33c" placeholder="请输入其他手术操作麻醉方式33" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师33" prop="c44x33">
          <el-input v-model="form.c44x33" placeholder="请输入其他手术操作麻醉医师33" />
        </el-form-item>
        <el-form-item label="其他手术操作编码34" prop="c35x34c">
          <el-input v-model="form.c35x34c" placeholder="请输入其他手术操作编码34" />
        </el-form-item>
        <el-form-item label="其他手术操作名称34" prop="c36x34n">
          <el-input v-model="form.c36x34n" placeholder="请输入其他手术操作名称34" />
        </el-form-item>
        <el-form-item label="其他手术操作日期34" prop="c37x34">
          <el-date-picker clearable
            v-model="form.c37x34"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期34">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别34" prop="c38x34">
          <el-input v-model="form.c38x34" placeholder="请输入其他手术操作级别34" />
        </el-form-item>
        <el-form-item label="其他手术操作术者34" prop="c39x34">
          <el-input v-model="form.c39x34" placeholder="请输入其他手术操作术者34" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助34" prop="c40x34">
          <el-input v-model="form.c40x34" placeholder="请输入其他手术操作Ⅰ助34" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助34" prop="c41x34">
          <el-input v-model="form.c41x34" placeholder="请输入其他手术操作Ⅱ助34" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级34" prop="c42x34c">
          <el-input v-model="form.c42x34c" placeholder="请输入其他手术操作切口愈合等级34" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式34" prop="c43x34c">
          <el-input v-model="form.c43x34c" placeholder="请输入其他手术操作麻醉方式34" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师34" prop="c44x34">
          <el-input v-model="form.c44x34" placeholder="请输入其他手术操作麻醉医师34" />
        </el-form-item>
        <el-form-item label="其他手术操作编码35" prop="c35x35c">
          <el-input v-model="form.c35x35c" placeholder="请输入其他手术操作编码35" />
        </el-form-item>
        <el-form-item label="其他手术操作名称35" prop="c36x35n">
          <el-input v-model="form.c36x35n" placeholder="请输入其他手术操作名称35" />
        </el-form-item>
        <el-form-item label="其他手术操作日期35" prop="c37x35">
          <el-date-picker clearable
            v-model="form.c37x35"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期35">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别35" prop="c38x35">
          <el-input v-model="form.c38x35" placeholder="请输入其他手术操作级别35" />
        </el-form-item>
        <el-form-item label="其他手术操作术者35" prop="c39x35">
          <el-input v-model="form.c39x35" placeholder="请输入其他手术操作术者35" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助35" prop="c40x35">
          <el-input v-model="form.c40x35" placeholder="请输入其他手术操作Ⅰ助35" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助35" prop="c41x35">
          <el-input v-model="form.c41x35" placeholder="请输入其他手术操作Ⅱ助35" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级35" prop="c42x35c">
          <el-input v-model="form.c42x35c" placeholder="请输入其他手术操作切口愈合等级35" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式35" prop="c43x35c">
          <el-input v-model="form.c43x35c" placeholder="请输入其他手术操作麻醉方式35" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师35" prop="c44x35">
          <el-input v-model="form.c44x35" placeholder="请输入其他手术操作麻醉医师35" />
        </el-form-item>
        <el-form-item label="其他手术操作编码36" prop="c35x36c">
          <el-input v-model="form.c35x36c" placeholder="请输入其他手术操作编码36" />
        </el-form-item>
        <el-form-item label="其他手术操作名称36" prop="c36x36n">
          <el-input v-model="form.c36x36n" placeholder="请输入其他手术操作名称36" />
        </el-form-item>
        <el-form-item label="其他手术操作日期36" prop="c37x36">
          <el-date-picker clearable
            v-model="form.c37x36"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期36">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别36" prop="c38x36">
          <el-input v-model="form.c38x36" placeholder="请输入其他手术操作级别36" />
        </el-form-item>
        <el-form-item label="其他手术操作术者36" prop="c39x36">
          <el-input v-model="form.c39x36" placeholder="请输入其他手术操作术者36" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助36" prop="c40x36">
          <el-input v-model="form.c40x36" placeholder="请输入其他手术操作Ⅰ助36" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助36" prop="c41x36">
          <el-input v-model="form.c41x36" placeholder="请输入其他手术操作Ⅱ助36" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级36" prop="c42x36c">
          <el-input v-model="form.c42x36c" placeholder="请输入其他手术操作切口愈合等级36" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式36" prop="c43x36c">
          <el-input v-model="form.c43x36c" placeholder="请输入其他手术操作麻醉方式36" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师36" prop="c44x36">
          <el-input v-model="form.c44x36" placeholder="请输入其他手术操作麻醉医师36" />
        </el-form-item>
        <el-form-item label="其他手术操作编码37" prop="c35x37c">
          <el-input v-model="form.c35x37c" placeholder="请输入其他手术操作编码37" />
        </el-form-item>
        <el-form-item label="其他手术操作名称37" prop="c36x37n">
          <el-input v-model="form.c36x37n" placeholder="请输入其他手术操作名称37" />
        </el-form-item>
        <el-form-item label="其他手术操作日期37" prop="c37x37">
          <el-date-picker clearable
            v-model="form.c37x37"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期37">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别37" prop="c38x37">
          <el-input v-model="form.c38x37" placeholder="请输入其他手术操作级别37" />
        </el-form-item>
        <el-form-item label="其他手术操作术者37" prop="c39x37">
          <el-input v-model="form.c39x37" placeholder="请输入其他手术操作术者37" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助37" prop="c40x37">
          <el-input v-model="form.c40x37" placeholder="请输入其他手术操作Ⅰ助37" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助37" prop="c41x37">
          <el-input v-model="form.c41x37" placeholder="请输入其他手术操作Ⅱ助37" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级37" prop="c42x37c">
          <el-input v-model="form.c42x37c" placeholder="请输入其他手术操作切口愈合等级37" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式37" prop="c43x37c">
          <el-input v-model="form.c43x37c" placeholder="请输入其他手术操作麻醉方式37" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师37" prop="c44x37">
          <el-input v-model="form.c44x37" placeholder="请输入其他手术操作麻醉医师37" />
        </el-form-item>
        <el-form-item label="其他手术操作编码38" prop="c35x38c">
          <el-input v-model="form.c35x38c" placeholder="请输入其他手术操作编码38" />
        </el-form-item>
        <el-form-item label="其他手术操作名称38" prop="c36x38n">
          <el-input v-model="form.c36x38n" placeholder="请输入其他手术操作名称38" />
        </el-form-item>
        <el-form-item label="其他手术操作日期38" prop="c37x38">
          <el-date-picker clearable
            v-model="form.c37x38"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期38">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别38" prop="c38x38">
          <el-input v-model="form.c38x38" placeholder="请输入其他手术操作级别38" />
        </el-form-item>
        <el-form-item label="其他手术操作术者38" prop="c39x38">
          <el-input v-model="form.c39x38" placeholder="请输入其他手术操作术者38" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助38" prop="c40x38">
          <el-input v-model="form.c40x38" placeholder="请输入其他手术操作Ⅰ助38" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助38" prop="c41x38">
          <el-input v-model="form.c41x38" placeholder="请输入其他手术操作Ⅱ助38" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级38" prop="c42x38c">
          <el-input v-model="form.c42x38c" placeholder="请输入其他手术操作切口愈合等级38" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式38" prop="c43x38c">
          <el-input v-model="form.c43x38c" placeholder="请输入其他手术操作麻醉方式38" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师38" prop="c44x38">
          <el-input v-model="form.c44x38" placeholder="请输入其他手术操作麻醉医师38" />
        </el-form-item>
        <el-form-item label="其他手术操作编码39" prop="c35x39c">
          <el-input v-model="form.c35x39c" placeholder="请输入其他手术操作编码39" />
        </el-form-item>
        <el-form-item label="其他手术操作名称39" prop="c36x39n">
          <el-input v-model="form.c36x39n" placeholder="请输入其他手术操作名称39" />
        </el-form-item>
        <el-form-item label="其他手术操作日期39" prop="c37x39">
          <el-date-picker clearable
            v-model="form.c37x39"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期39">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别39" prop="c38x39">
          <el-input v-model="form.c38x39" placeholder="请输入其他手术操作级别39" />
        </el-form-item>
        <el-form-item label="其他手术操作术者39" prop="c39x39">
          <el-input v-model="form.c39x39" placeholder="请输入其他手术操作术者39" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助39" prop="c40x39">
          <el-input v-model="form.c40x39" placeholder="请输入其他手术操作Ⅰ助39" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助39" prop="c41x39">
          <el-input v-model="form.c41x39" placeholder="请输入其他手术操作Ⅱ助39" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级39" prop="c42x39c">
          <el-input v-model="form.c42x39c" placeholder="请输入其他手术操作切口愈合等级39" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式39" prop="c43x39c">
          <el-input v-model="form.c43x39c" placeholder="请输入其他手术操作麻醉方式39" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师39" prop="c44x39">
          <el-input v-model="form.c44x39" placeholder="请输入其他手术操作麻醉医师39" />
        </el-form-item>
        <el-form-item label="其他手术操作编码40" prop="c35x40c">
          <el-input v-model="form.c35x40c" placeholder="请输入其他手术操作编码40" />
        </el-form-item>
        <el-form-item label="其他手术操作名称40" prop="c36x40n">
          <el-input v-model="form.c36x40n" placeholder="请输入其他手术操作名称40" />
        </el-form-item>
        <el-form-item label="其他手术操作日期40" prop="c37x40">
          <el-date-picker clearable
            v-model="form.c37x40"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择其他手术操作日期40">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="其他手术操作级别40" prop="c38x40">
          <el-input v-model="form.c38x40" placeholder="请输入其他手术操作级别40" />
        </el-form-item>
        <el-form-item label="其他手术操作术者40" prop="c39x40">
          <el-input v-model="form.c39x40" placeholder="请输入其他手术操作术者40" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅰ助40" prop="c40x40">
          <el-input v-model="form.c40x40" placeholder="请输入其他手术操作Ⅰ助40" />
        </el-form-item>
        <el-form-item label="其他手术操作Ⅱ助40" prop="c41x40">
          <el-input v-model="form.c41x40" placeholder="请输入其他手术操作Ⅱ助40" />
        </el-form-item>
        <el-form-item label="其他手术操作切口愈合等级40" prop="c42x40c">
          <el-input v-model="form.c42x40c" placeholder="请输入其他手术操作切口愈合等级40" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉方式40" prop="c43x40c">
          <el-input v-model="form.c43x40c" placeholder="请输入其他手术操作麻醉方式40" />
        </el-form-item>
        <el-form-item label="其他手术操作麻醉医师40" prop="c44x40">
          <el-input v-model="form.c44x40" placeholder="请输入其他手术操作麻醉医师40" />
        </el-form-item>
        <el-form-item label="住院总费用" prop="d01">
          <el-input v-model="form.d01" placeholder="请输入住院总费用" />
        </el-form-item>
        <el-form-item label="住院总费用其中自付金额" prop="d09">
          <el-input v-model="form.d09" placeholder="请输入住院总费用其中自付金额" />
        </el-form-item>
        <el-form-item label="1.一般医疗服务费" prop="d11">
          <el-input v-model="form.d11" placeholder="请输入1.一般医疗服务费" />
        </el-form-item>
        <el-form-item label="2.一般治疗操作费" prop="d12">
          <el-input v-model="form.d12" placeholder="请输入2.一般治疗操作费" />
        </el-form-item>
        <el-form-item label="3.护理费" prop="d13">
          <el-input v-model="form.d13" placeholder="请输入3.护理费" />
        </el-form-item>
        <el-form-item label="4.综合医疗服务类其他费用" prop="d14">
          <el-input v-model="form.d14" placeholder="请输入4.综合医疗服务类其他费用" />
        </el-form-item>
        <el-form-item label="5.病理诊断费" prop="d15">
          <el-input v-model="form.d15" placeholder="请输入5.病理诊断费" />
        </el-form-item>
        <el-form-item label="6.实验室诊断费" prop="d16">
          <el-input v-model="form.d16" placeholder="请输入6.实验室诊断费" />
        </el-form-item>
        <el-form-item label="7.影像学诊断费" prop="d17">
          <el-input v-model="form.d17" placeholder="请输入7.影像学诊断费" />
        </el-form-item>
        <el-form-item label="8.临床诊断项目费" prop="d18">
          <el-input v-model="form.d18" placeholder="请输入8.临床诊断项目费" />
        </el-form-item>
        <el-form-item label="9.非手术治疗项目费" prop="d19">
          <el-input v-model="form.d19" placeholder="请输入9.非手术治疗项目费" />
        </el-form-item>
        <el-form-item label="其中:临床物理治疗费" prop="d19x01">
          <el-input v-model="form.d19x01" placeholder="请输入其中:临床物理治疗费" />
        </el-form-item>
        <el-form-item label="10.手术治疗费" prop="d20">
          <el-input v-model="form.d20" placeholder="请输入10.手术治疗费" />
        </el-form-item>
        <el-form-item label="其中:麻醉费" prop="d20x01">
          <el-input v-model="form.d20x01" placeholder="请输入其中:麻醉费" />
        </el-form-item>
        <el-form-item label="其中:手术费" prop="d20x02">
          <el-input v-model="form.d20x02" placeholder="请输入其中:手术费" />
        </el-form-item>
        <el-form-item label="11.康复费" prop="d21">
          <el-input v-model="form.d21" placeholder="请输入11.康复费" />
        </el-form-item>
        <el-form-item label="12.中医治疗费" prop="d22">
          <el-input v-model="form.d22" placeholder="请输入12.中医治疗费" />
        </el-form-item>
        <el-form-item label="13.西药费" prop="d23">
          <el-input v-model="form.d23" placeholder="请输入13.西药费" />
        </el-form-item>
        <el-form-item label="其中:抗菌药物费" prop="d23x01">
          <el-input v-model="form.d23x01" placeholder="请输入其中:抗菌药物费" />
        </el-form-item>
        <el-form-item label="14.中成药费" prop="d24">
          <el-input v-model="form.d24" placeholder="请输入14.中成药费" />
        </el-form-item>
        <el-form-item label="15.中草药费" prop="d25">
          <el-input v-model="form.d25" placeholder="请输入15.中草药费" />
        </el-form-item>
        <el-form-item label="16.血费" prop="d26">
          <el-input v-model="form.d26" placeholder="请输入16.血费" />
        </el-form-item>
        <el-form-item label="17.白蛋白类制品费" prop="d27">
          <el-input v-model="form.d27" placeholder="请输入17.白蛋白类制品费" />
        </el-form-item>
        <el-form-item label="18.球蛋白类制品费" prop="d28">
          <el-input v-model="form.d28" placeholder="请输入18.球蛋白类制品费" />
        </el-form-item>
        <el-form-item label="19.凝血因子类制品费" prop="d29">
          <el-input v-model="form.d29" placeholder="请输入19.凝血因子类制品费" />
        </el-form-item>
        <el-form-item label="20.细胞因子类制品费" prop="d30">
          <el-input v-model="form.d30" placeholder="请输入20.细胞因子类制品费" />
        </el-form-item>
        <el-form-item label="21.检查用一次性医用材料费" prop="d31">
          <el-input v-model="form.d31" placeholder="请输入21.检查用一次性医用材料费" />
        </el-form-item>
        <el-form-item label="22.治疗用一次性医用材料费" prop="d32">
          <el-input v-model="form.d32" placeholder="请输入22.治疗用一次性医用材料费" />
        </el-form-item>
        <el-form-item label="23.手术用一次性医用材料费" prop="d33">
          <el-input v-model="form.d33" placeholder="请输入23.手术用一次性医用材料费" />
        </el-form-item>
        <el-form-item label="24.其他费" prop="d34">
          <el-input v-model="form.d34" placeholder="请输入24.其他费" />
        </el-form-item>
        <el-form-item label="扩展字段1-预留" prop="e01">
          <el-input v-model="form.e01" placeholder="请输入扩展字段1-预留" />
        </el-form-item>
        <el-form-item label="扩展字段2-预留" prop="e02">
          <el-input v-model="form.e02" placeholder="请输入扩展字段2-预留" />
        </el-form-item>
        <el-form-item label="扩展字段3-预留" prop="e03">
          <el-input v-model="form.e03" placeholder="请输入扩展字段3-预留" />
        </el-form-item>
        <el-form-item label="扩展字段4-预留" prop="e04">
          <el-input v-model="form.e04" placeholder="请输入扩展字段4-预留" />
        </el-form-item>
        <el-form-item label="扩展字段5-预留时间" prop="e05">
          <el-date-picker clearable
            v-model="form.e05"
            type="datetime"
            value-format="YYYY-MM-DD HH:mm:ss"
            placeholder="请选择扩展字段5-预留时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="扩展字段6-预留金额" prop="e06">
          <el-input v-model="form.e06" placeholder="请输入扩展字段6-预留金额" />
        </el-form-item>
        <el-form-item label="扩展字段7-预留数字" prop="e07">
          <el-input v-model="form.e07" placeholder="请输入扩展字段7-预留数字" />
        </el-form-item>
        <el-form-item label="扩展字段8-预留文本" prop="e08">
          <el-input v-model="form.e08" placeholder="请输入扩展字段8-预留文本" />
        </el-form-item>
        <el-form-item label="扩展字段9-预留布尔值" prop="e09">
          <el-input v-model="form.e09" placeholder="请输入扩展字段9-预留布尔值" />
        </el-form-item>
        <el-form-item label="扩展字段10-预留编码" prop="e10">
          <el-input v-model="form.e10" placeholder="请输入扩展字段10-预留编码" />
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

<script setup name="NatdssB04MedicalRecordFrontSheetNonTcmSupplement" lang="ts">
import { listNatdssB04MedicalRecordFrontSheetNonTcmSupplement, getNatdssB04MedicalRecordFrontSheetNonTcmSupplement, delNatdssB04MedicalRecordFrontSheetNonTcmSupplement, addNatdssB04MedicalRecordFrontSheetNonTcmSupplement, updateNatdssB04MedicalRecordFrontSheetNonTcmSupplement } from '@/api/natdss/natdssB04MedicalRecordFrontSheetNonTcmSupplement';
import { NatdssB04MedicalRecordFrontSheetNonTcmSupplementVO, NatdssB04MedicalRecordFrontSheetNonTcmSupplementQuery, NatdssB04MedicalRecordFrontSheetNonTcmSupplementForm } from '@/api/natdss/natdssB04MedicalRecordFrontSheetNonTcmSupplement/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const natdssB04MedicalRecordFrontSheetNonTcmSupplementList = ref<NatdssB04MedicalRecordFrontSheetNonTcmSupplementVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const natdssB04MedicalRecordFrontSheetNonTcmSupplementFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: NatdssB04MedicalRecordFrontSheetNonTcmSupplementForm = {
  patientId: undefined,
  visitSn: undefined,
  c35x01c: undefined,
  c36x01n: undefined,
  c37x01: undefined,
  c38x01: undefined,
  c39x01: undefined,
  c40x01: undefined,
  c41x01: undefined,
  c42x01c: undefined,
  c43x01c: undefined,
  c44x01: undefined,
  c35x02c: undefined,
  c36x02n: undefined,
  c37x02: undefined,
  c38x02: undefined,
  c39x02: undefined,
  c40x02: undefined,
  c41x02: undefined,
  c42x02c: undefined,
  c43x02c: undefined,
  c44x02: undefined,
  c35x03c: undefined,
  c36x03n: undefined,
  c37x03: undefined,
  c38x03: undefined,
  c39x03: undefined,
  c40x03: undefined,
  c41x03: undefined,
  c42x03c: undefined,
  c43x03c: undefined,
  c44x03: undefined,
  c35x04c: undefined,
  c36x04n: undefined,
  c37x04: undefined,
  c38x04: undefined,
  c39x04: undefined,
  c40x04: undefined,
  c41x04: undefined,
  c42x04c: undefined,
  c43x04c: undefined,
  c44x04: undefined,
  c35x05c: undefined,
  c36x05n: undefined,
  c37x05: undefined,
  c38x05: undefined,
  c39x05: undefined,
  c40x05: undefined,
  c41x05: undefined,
  c42x05c: undefined,
  c43x05c: undefined,
  c44x05: undefined,
  c35x06c: undefined,
  c36x06n: undefined,
  c37x06: undefined,
  c38x06: undefined,
  c39x06: undefined,
  c40x06: undefined,
  c41x06: undefined,
  c42x06c: undefined,
  c43x06c: undefined,
  c44x06: undefined,
  c35x07c: undefined,
  c36x07n: undefined,
  c37x07: undefined,
  c38x07: undefined,
  c39x07: undefined,
  c40x07: undefined,
  c41x07: undefined,
  c42x07c: undefined,
  c43x07c: undefined,
  c44x07: undefined,
  c35x08c: undefined,
  c36x08n: undefined,
  c37x08: undefined,
  c38x08: undefined,
  c39x08: undefined,
  c40x08: undefined,
  c41x08: undefined,
  c42x08c: undefined,
  c43x08c: undefined,
  c44x08: undefined,
  c35x09c: undefined,
  c36x09n: undefined,
  c37x09: undefined,
  c38x09: undefined,
  c39x09: undefined,
  c40x09: undefined,
  c41x09: undefined,
  c42x09c: undefined,
  c43x09c: undefined,
  c44x09: undefined,
  c35x10c: undefined,
  c36x10n: undefined,
  c37x10: undefined,
  c38x10: undefined,
  c39x10: undefined,
  c40x10: undefined,
  c41x10: undefined,
  c42x10c: undefined,
  c43x10c: undefined,
  c44x10: undefined,
  c35x11c: undefined,
  c36x11n: undefined,
  c37x11: undefined,
  c38x11: undefined,
  c39x11: undefined,
  c40x11: undefined,
  c41x11: undefined,
  c42x11c: undefined,
  c43x11c: undefined,
  c44x11: undefined,
  c35x12c: undefined,
  c36x12n: undefined,
  c37x12: undefined,
  c38x12: undefined,
  c39x12: undefined,
  c40x12: undefined,
  c41x12: undefined,
  c42x12c: undefined,
  c43x12c: undefined,
  c44x12: undefined,
  c35x13c: undefined,
  c36x13n: undefined,
  c37x13: undefined,
  c38x13: undefined,
  c39x13: undefined,
  c40x13: undefined,
  c41x13: undefined,
  c42x13c: undefined,
  c43x13c: undefined,
  c44x13: undefined,
  c35x14c: undefined,
  c36x14n: undefined,
  c37x14: undefined,
  c38x14: undefined,
  c39x14: undefined,
  c40x14: undefined,
  c41x14: undefined,
  c42x14c: undefined,
  c43x14c: undefined,
  c44x14: undefined,
  c35x15c: undefined,
  c36x15n: undefined,
  c37x15: undefined,
  c38x15: undefined,
  c39x15: undefined,
  c40x15: undefined,
  c41x15: undefined,
  c42x15c: undefined,
  c43x15c: undefined,
  c44x15: undefined,
  c35x16c: undefined,
  c36x16n: undefined,
  c37x16: undefined,
  c38x16: undefined,
  c39x16: undefined,
  c40x16: undefined,
  c41x16: undefined,
  c42x16c: undefined,
  c43x16c: undefined,
  c44x16: undefined,
  c35x17c: undefined,
  c36x17n: undefined,
  c37x17: undefined,
  c38x17: undefined,
  c39x17: undefined,
  c40x17: undefined,
  c41x17: undefined,
  c42x17c: undefined,
  c43x17c: undefined,
  c44x17: undefined,
  c35x18c: undefined,
  c36x18n: undefined,
  c37x18: undefined,
  c38x18: undefined,
  c39x18: undefined,
  c40x18: undefined,
  c41x18: undefined,
  c42x18c: undefined,
  c43x18c: undefined,
  c44x18: undefined,
  c35x19c: undefined,
  c36x19n: undefined,
  c37x19: undefined,
  c38x19: undefined,
  c39x19: undefined,
  c40x19: undefined,
  c41x19: undefined,
  c42x19c: undefined,
  c43x19c: undefined,
  c44x19: undefined,
  c35x20c: undefined,
  c36x20n: undefined,
  c37x20: undefined,
  c38x20: undefined,
  c39x20: undefined,
  c40x20: undefined,
  c41x20: undefined,
  c42x20c: undefined,
  c43x20c: undefined,
  c44x20: undefined,
  c35x21c: undefined,
  c36x21n: undefined,
  c37x21: undefined,
  c38x21: undefined,
  c39x21: undefined,
  c40x21: undefined,
  c41x21: undefined,
  c42x21c: undefined,
  c43x21c: undefined,
  c44x21: undefined,
  c35x22c: undefined,
  c36x22n: undefined,
  c37x22: undefined,
  c38x22: undefined,
  c39x22: undefined,
  c40x22: undefined,
  c41x22: undefined,
  c42x22c: undefined,
  c43x22c: undefined,
  c44x22: undefined,
  c35x23c: undefined,
  c36x23n: undefined,
  c37x23: undefined,
  c38x23: undefined,
  c39x23: undefined,
  c40x23: undefined,
  c41x23: undefined,
  c42x23c: undefined,
  c43x23c: undefined,
  c44x23: undefined,
  c35x24c: undefined,
  c36x24n: undefined,
  c37x24: undefined,
  c38x24: undefined,
  c39x24: undefined,
  c40x24: undefined,
  c41x24: undefined,
  c42x24c: undefined,
  c43x24c: undefined,
  c44x24: undefined,
  c35x25c: undefined,
  c36x25n: undefined,
  c37x25: undefined,
  c38x25: undefined,
  c39x25: undefined,
  c40x25: undefined,
  c41x25: undefined,
  c42x25c: undefined,
  c43x25c: undefined,
  c44x25: undefined,
  c35x26c: undefined,
  c36x26n: undefined,
  c37x26: undefined,
  c38x26: undefined,
  c39x26: undefined,
  c40x26: undefined,
  c41x26: undefined,
  c42x26c: undefined,
  c43x26c: undefined,
  c44x26: undefined,
  c35x27c: undefined,
  c36x27n: undefined,
  c37x27: undefined,
  c38x27: undefined,
  c39x27: undefined,
  c40x27: undefined,
  c41x27: undefined,
  c42x27c: undefined,
  c43x27c: undefined,
  c44x27: undefined,
  c35x28c: undefined,
  c36x28n: undefined,
  c37x28: undefined,
  c38x28: undefined,
  c39x28: undefined,
  c40x28: undefined,
  c41x28: undefined,
  c42x28c: undefined,
  c43x28c: undefined,
  c44x28: undefined,
  c35x29c: undefined,
  c36x29n: undefined,
  c37x29: undefined,
  c38x29: undefined,
  c39x29: undefined,
  c40x29: undefined,
  c41x29: undefined,
  c42x29c: undefined,
  c43x29c: undefined,
  c44x29: undefined,
  c35x30c: undefined,
  c36x30n: undefined,
  c37x30: undefined,
  c38x30: undefined,
  c39x30: undefined,
  c40x30: undefined,
  c41x30: undefined,
  c42x30c: undefined,
  c43x30c: undefined,
  c44x30: undefined,
  c35x31c: undefined,
  c36x31n: undefined,
  c37x31: undefined,
  c38x31: undefined,
  c39x31: undefined,
  c40x31: undefined,
  c41x31: undefined,
  c42x31c: undefined,
  c43x31c: undefined,
  c44x31: undefined,
  c35x32c: undefined,
  c36x32n: undefined,
  c37x32: undefined,
  c38x32: undefined,
  c39x32: undefined,
  c40x32: undefined,
  c41x32: undefined,
  c42x32c: undefined,
  c43x32c: undefined,
  c44x32: undefined,
  c35x33c: undefined,
  c36x33n: undefined,
  c37x33: undefined,
  c38x33: undefined,
  c39x33: undefined,
  c40x33: undefined,
  c41x33: undefined,
  c42x33c: undefined,
  c43x33c: undefined,
  c44x33: undefined,
  c35x34c: undefined,
  c36x34n: undefined,
  c37x34: undefined,
  c38x34: undefined,
  c39x34: undefined,
  c40x34: undefined,
  c41x34: undefined,
  c42x34c: undefined,
  c43x34c: undefined,
  c44x34: undefined,
  c35x35c: undefined,
  c36x35n: undefined,
  c37x35: undefined,
  c38x35: undefined,
  c39x35: undefined,
  c40x35: undefined,
  c41x35: undefined,
  c42x35c: undefined,
  c43x35c: undefined,
  c44x35: undefined,
  c35x36c: undefined,
  c36x36n: undefined,
  c37x36: undefined,
  c38x36: undefined,
  c39x36: undefined,
  c40x36: undefined,
  c41x36: undefined,
  c42x36c: undefined,
  c43x36c: undefined,
  c44x36: undefined,
  c35x37c: undefined,
  c36x37n: undefined,
  c37x37: undefined,
  c38x37: undefined,
  c39x37: undefined,
  c40x37: undefined,
  c41x37: undefined,
  c42x37c: undefined,
  c43x37c: undefined,
  c44x37: undefined,
  c35x38c: undefined,
  c36x38n: undefined,
  c37x38: undefined,
  c38x38: undefined,
  c39x38: undefined,
  c40x38: undefined,
  c41x38: undefined,
  c42x38c: undefined,
  c43x38c: undefined,
  c44x38: undefined,
  c35x39c: undefined,
  c36x39n: undefined,
  c37x39: undefined,
  c38x39: undefined,
  c39x39: undefined,
  c40x39: undefined,
  c41x39: undefined,
  c42x39c: undefined,
  c43x39c: undefined,
  c44x39: undefined,
  c35x40c: undefined,
  c36x40n: undefined,
  c37x40: undefined,
  c38x40: undefined,
  c39x40: undefined,
  c40x40: undefined,
  c41x40: undefined,
  c42x40c: undefined,
  c43x40c: undefined,
  c44x40: undefined,
  d01: undefined,
  d09: undefined,
  d11: undefined,
  d12: undefined,
  d13: undefined,
  d14: undefined,
  d15: undefined,
  d16: undefined,
  d17: undefined,
  d18: undefined,
  d19: undefined,
  d19x01: undefined,
  d20: undefined,
  d20x01: undefined,
  d20x02: undefined,
  d21: undefined,
  d22: undefined,
  d23: undefined,
  d23x01: undefined,
  d24: undefined,
  d25: undefined,
  d26: undefined,
  d27: undefined,
  d28: undefined,
  d29: undefined,
  d30: undefined,
  d31: undefined,
  d32: undefined,
  d33: undefined,
  d34: undefined,
  e01: undefined,
  e02: undefined,
  e03: undefined,
  e04: undefined,
  e05: undefined,
  e06: undefined,
  e07: undefined,
  e08: undefined,
  e09: undefined,
  e10: undefined
}
const data = reactive<PageData<NatdssB04MedicalRecordFrontSheetNonTcmSupplementForm, NatdssB04MedicalRecordFrontSheetNonTcmSupplementQuery>>({
  form: {...initFormData},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    c35x01c: undefined,
    c36x01n: undefined,
    c37x01: undefined,
    c38x01: undefined,
    c39x01: undefined,
    c40x01: undefined,
    c41x01: undefined,
    c42x01c: undefined,
    c43x01c: undefined,
    c44x01: undefined,
    c35x02c: undefined,
    c36x02n: undefined,
    c37x02: undefined,
    c38x02: undefined,
    c39x02: undefined,
    c40x02: undefined,
    c41x02: undefined,
    c42x02c: undefined,
    c43x02c: undefined,
    c44x02: undefined,
    c35x03c: undefined,
    c36x03n: undefined,
    c37x03: undefined,
    c38x03: undefined,
    c39x03: undefined,
    c40x03: undefined,
    c41x03: undefined,
    c42x03c: undefined,
    c43x03c: undefined,
    c44x03: undefined,
    c35x04c: undefined,
    c36x04n: undefined,
    c37x04: undefined,
    c38x04: undefined,
    c39x04: undefined,
    c40x04: undefined,
    c41x04: undefined,
    c42x04c: undefined,
    c43x04c: undefined,
    c44x04: undefined,
    c35x05c: undefined,
    c36x05n: undefined,
    c37x05: undefined,
    c38x05: undefined,
    c39x05: undefined,
    c40x05: undefined,
    c41x05: undefined,
    c42x05c: undefined,
    c43x05c: undefined,
    c44x05: undefined,
    c35x06c: undefined,
    c36x06n: undefined,
    c37x06: undefined,
    c38x06: undefined,
    c39x06: undefined,
    c40x06: undefined,
    c41x06: undefined,
    c42x06c: undefined,
    c43x06c: undefined,
    c44x06: undefined,
    c35x07c: undefined,
    c36x07n: undefined,
    c37x07: undefined,
    c38x07: undefined,
    c39x07: undefined,
    c40x07: undefined,
    c41x07: undefined,
    c42x07c: undefined,
    c43x07c: undefined,
    c44x07: undefined,
    c35x08c: undefined,
    c36x08n: undefined,
    c37x08: undefined,
    c38x08: undefined,
    c39x08: undefined,
    c40x08: undefined,
    c41x08: undefined,
    c42x08c: undefined,
    c43x08c: undefined,
    c44x08: undefined,
    c35x09c: undefined,
    c36x09n: undefined,
    c37x09: undefined,
    c38x09: undefined,
    c39x09: undefined,
    c40x09: undefined,
    c41x09: undefined,
    c42x09c: undefined,
    c43x09c: undefined,
    c44x09: undefined,
    c35x10c: undefined,
    c36x10n: undefined,
    c37x10: undefined,
    c38x10: undefined,
    c39x10: undefined,
    c40x10: undefined,
    c41x10: undefined,
    c42x10c: undefined,
    c43x10c: undefined,
    c44x10: undefined,
    c35x11c: undefined,
    c36x11n: undefined,
    c37x11: undefined,
    c38x11: undefined,
    c39x11: undefined,
    c40x11: undefined,
    c41x11: undefined,
    c42x11c: undefined,
    c43x11c: undefined,
    c44x11: undefined,
    c35x12c: undefined,
    c36x12n: undefined,
    c37x12: undefined,
    c38x12: undefined,
    c39x12: undefined,
    c40x12: undefined,
    c41x12: undefined,
    c42x12c: undefined,
    c43x12c: undefined,
    c44x12: undefined,
    c35x13c: undefined,
    c36x13n: undefined,
    c37x13: undefined,
    c38x13: undefined,
    c39x13: undefined,
    c40x13: undefined,
    c41x13: undefined,
    c42x13c: undefined,
    c43x13c: undefined,
    c44x13: undefined,
    c35x14c: undefined,
    c36x14n: undefined,
    c37x14: undefined,
    c38x14: undefined,
    c39x14: undefined,
    c40x14: undefined,
    c41x14: undefined,
    c42x14c: undefined,
    c43x14c: undefined,
    c44x14: undefined,
    c35x15c: undefined,
    c36x15n: undefined,
    c37x15: undefined,
    c38x15: undefined,
    c39x15: undefined,
    c40x15: undefined,
    c41x15: undefined,
    c42x15c: undefined,
    c43x15c: undefined,
    c44x15: undefined,
    c35x16c: undefined,
    c36x16n: undefined,
    c37x16: undefined,
    c38x16: undefined,
    c39x16: undefined,
    c40x16: undefined,
    c41x16: undefined,
    c42x16c: undefined,
    c43x16c: undefined,
    c44x16: undefined,
    c35x17c: undefined,
    c36x17n: undefined,
    c37x17: undefined,
    c38x17: undefined,
    c39x17: undefined,
    c40x17: undefined,
    c41x17: undefined,
    c42x17c: undefined,
    c43x17c: undefined,
    c44x17: undefined,
    c35x18c: undefined,
    c36x18n: undefined,
    c37x18: undefined,
    c38x18: undefined,
    c39x18: undefined,
    c40x18: undefined,
    c41x18: undefined,
    c42x18c: undefined,
    c43x18c: undefined,
    c44x18: undefined,
    c35x19c: undefined,
    c36x19n: undefined,
    c37x19: undefined,
    c38x19: undefined,
    c39x19: undefined,
    c40x19: undefined,
    c41x19: undefined,
    c42x19c: undefined,
    c43x19c: undefined,
    c44x19: undefined,
    c35x20c: undefined,
    c36x20n: undefined,
    c37x20: undefined,
    c38x20: undefined,
    c39x20: undefined,
    c40x20: undefined,
    c41x20: undefined,
    c42x20c: undefined,
    c43x20c: undefined,
    c44x20: undefined,
    c35x21c: undefined,
    c36x21n: undefined,
    c37x21: undefined,
    c38x21: undefined,
    c39x21: undefined,
    c40x21: undefined,
    c41x21: undefined,
    c42x21c: undefined,
    c43x21c: undefined,
    c44x21: undefined,
    c35x22c: undefined,
    c36x22n: undefined,
    c37x22: undefined,
    c38x22: undefined,
    c39x22: undefined,
    c40x22: undefined,
    c41x22: undefined,
    c42x22c: undefined,
    c43x22c: undefined,
    c44x22: undefined,
    c35x23c: undefined,
    c36x23n: undefined,
    c37x23: undefined,
    c38x23: undefined,
    c39x23: undefined,
    c40x23: undefined,
    c41x23: undefined,
    c42x23c: undefined,
    c43x23c: undefined,
    c44x23: undefined,
    c35x24c: undefined,
    c36x24n: undefined,
    c37x24: undefined,
    c38x24: undefined,
    c39x24: undefined,
    c40x24: undefined,
    c41x24: undefined,
    c42x24c: undefined,
    c43x24c: undefined,
    c44x24: undefined,
    c35x25c: undefined,
    c36x25n: undefined,
    c37x25: undefined,
    c38x25: undefined,
    c39x25: undefined,
    c40x25: undefined,
    c41x25: undefined,
    c42x25c: undefined,
    c43x25c: undefined,
    c44x25: undefined,
    c35x26c: undefined,
    c36x26n: undefined,
    c37x26: undefined,
    c38x26: undefined,
    c39x26: undefined,
    c40x26: undefined,
    c41x26: undefined,
    c42x26c: undefined,
    c43x26c: undefined,
    c44x26: undefined,
    c35x27c: undefined,
    c36x27n: undefined,
    c37x27: undefined,
    c38x27: undefined,
    c39x27: undefined,
    c40x27: undefined,
    c41x27: undefined,
    c42x27c: undefined,
    c43x27c: undefined,
    c44x27: undefined,
    c35x28c: undefined,
    c36x28n: undefined,
    c37x28: undefined,
    c38x28: undefined,
    c39x28: undefined,
    c40x28: undefined,
    c41x28: undefined,
    c42x28c: undefined,
    c43x28c: undefined,
    c44x28: undefined,
    c35x29c: undefined,
    c36x29n: undefined,
    c37x29: undefined,
    c38x29: undefined,
    c39x29: undefined,
    c40x29: undefined,
    c41x29: undefined,
    c42x29c: undefined,
    c43x29c: undefined,
    c44x29: undefined,
    c35x30c: undefined,
    c36x30n: undefined,
    c37x30: undefined,
    c38x30: undefined,
    c39x30: undefined,
    c40x30: undefined,
    c41x30: undefined,
    c42x30c: undefined,
    c43x30c: undefined,
    c44x30: undefined,
    c35x31c: undefined,
    c36x31n: undefined,
    c37x31: undefined,
    c38x31: undefined,
    c39x31: undefined,
    c40x31: undefined,
    c41x31: undefined,
    c42x31c: undefined,
    c43x31c: undefined,
    c44x31: undefined,
    c35x32c: undefined,
    c36x32n: undefined,
    c37x32: undefined,
    c38x32: undefined,
    c39x32: undefined,
    c40x32: undefined,
    c41x32: undefined,
    c42x32c: undefined,
    c43x32c: undefined,
    c44x32: undefined,
    c35x33c: undefined,
    c36x33n: undefined,
    c37x33: undefined,
    c38x33: undefined,
    c39x33: undefined,
    c40x33: undefined,
    c41x33: undefined,
    c42x33c: undefined,
    c43x33c: undefined,
    c44x33: undefined,
    c35x34c: undefined,
    c36x34n: undefined,
    c37x34: undefined,
    c38x34: undefined,
    c39x34: undefined,
    c40x34: undefined,
    c41x34: undefined,
    c42x34c: undefined,
    c43x34c: undefined,
    c44x34: undefined,
    c35x35c: undefined,
    c36x35n: undefined,
    c37x35: undefined,
    c38x35: undefined,
    c39x35: undefined,
    c40x35: undefined,
    c41x35: undefined,
    c42x35c: undefined,
    c43x35c: undefined,
    c44x35: undefined,
    c35x36c: undefined,
    c36x36n: undefined,
    c37x36: undefined,
    c38x36: undefined,
    c39x36: undefined,
    c40x36: undefined,
    c41x36: undefined,
    c42x36c: undefined,
    c43x36c: undefined,
    c44x36: undefined,
    c35x37c: undefined,
    c36x37n: undefined,
    c37x37: undefined,
    c38x37: undefined,
    c39x37: undefined,
    c40x37: undefined,
    c41x37: undefined,
    c42x37c: undefined,
    c43x37c: undefined,
    c44x37: undefined,
    c35x38c: undefined,
    c36x38n: undefined,
    c37x38: undefined,
    c38x38: undefined,
    c39x38: undefined,
    c40x38: undefined,
    c41x38: undefined,
    c42x38c: undefined,
    c43x38c: undefined,
    c44x38: undefined,
    c35x39c: undefined,
    c36x39n: undefined,
    c37x39: undefined,
    c38x39: undefined,
    c39x39: undefined,
    c40x39: undefined,
    c41x39: undefined,
    c42x39c: undefined,
    c43x39c: undefined,
    c44x39: undefined,
    c35x40c: undefined,
    c36x40n: undefined,
    c37x40: undefined,
    c38x40: undefined,
    c39x40: undefined,
    c40x40: undefined,
    c41x40: undefined,
    c42x40c: undefined,
    c43x40c: undefined,
    c44x40: undefined,
    d01: undefined,
    d09: undefined,
    d11: undefined,
    d12: undefined,
    d13: undefined,
    d14: undefined,
    d15: undefined,
    d16: undefined,
    d17: undefined,
    d18: undefined,
    d19: undefined,
    d19x01: undefined,
    d20: undefined,
    d20x01: undefined,
    d20x02: undefined,
    d21: undefined,
    d22: undefined,
    d23: undefined,
    d23x01: undefined,
    d24: undefined,
    d25: undefined,
    d26: undefined,
    d27: undefined,
    d28: undefined,
    d29: undefined,
    d30: undefined,
    d31: undefined,
    d32: undefined,
    d33: undefined,
    d34: undefined,
    e01: undefined,
    e02: undefined,
    e03: undefined,
    e04: undefined,
    e05: undefined,
    e06: undefined,
    e07: undefined,
    e08: undefined,
    e09: undefined,
    e10: undefined,
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
    d01: [
      { required: true, message: "住院总费用不能为空", trigger: "blur" }
    ],
    d09: [
      { required: true, message: "住院总费用其中自付金额不能为空", trigger: "blur" }
    ],
    d11: [
      { required: true, message: "1.一般医疗服务费不能为空", trigger: "blur" }
    ],
    d12: [
      { required: true, message: "2.一般治疗操作费不能为空", trigger: "blur" }
    ],
    d13: [
      { required: true, message: "3.护理费不能为空", trigger: "blur" }
    ],
    d14: [
      { required: true, message: "4.综合医疗服务类其他费用不能为空", trigger: "blur" }
    ],
    d15: [
      { required: true, message: "5.病理诊断费不能为空", trigger: "blur" }
    ],
    d16: [
      { required: true, message: "6.实验室诊断费不能为空", trigger: "blur" }
    ],
    d17: [
      { required: true, message: "7.影像学诊断费不能为空", trigger: "blur" }
    ],
    d18: [
      { required: true, message: "8.临床诊断项目费不能为空", trigger: "blur" }
    ],
    d19: [
      { required: true, message: "9.非手术治疗项目费不能为空", trigger: "blur" }
    ],
    d19x01: [
      { required: true, message: "其中:临床物理治疗费不能为空", trigger: "blur" }
    ],
    d20: [
      { required: true, message: "10.手术治疗费不能为空", trigger: "blur" }
    ],
    d20x01: [
      { required: true, message: "其中:麻醉费不能为空", trigger: "blur" }
    ],
    d20x02: [
      { required: true, message: "其中:手术费不能为空", trigger: "blur" }
    ],
    d21: [
      { required: true, message: "11.康复费不能为空", trigger: "blur" }
    ],
    d22: [
      { required: true, message: "12.中医治疗费不能为空", trigger: "blur" }
    ],
    d23: [
      { required: true, message: "13.西药费不能为空", trigger: "blur" }
    ],
    d23x01: [
      { required: true, message: "其中:抗菌药物费不能为空", trigger: "blur" }
    ],
    d24: [
      { required: true, message: "14.中成药费不能为空", trigger: "blur" }
    ],
    d25: [
      { required: true, message: "15.中草药费不能为空", trigger: "blur" }
    ],
    d26: [
      { required: true, message: "16.血费不能为空", trigger: "blur" }
    ],
    d27: [
      { required: true, message: "17.白蛋白类制品费不能为空", trigger: "blur" }
    ],
    d28: [
      { required: true, message: "18.球蛋白类制品费不能为空", trigger: "blur" }
    ],
    d29: [
      { required: true, message: "19.凝血因子类制品费不能为空", trigger: "blur" }
    ],
    d30: [
      { required: true, message: "20.细胞因子类制品费不能为空", trigger: "blur" }
    ],
    d31: [
      { required: true, message: "21.检查用一次性医用材料费不能为空", trigger: "blur" }
    ],
    d32: [
      { required: true, message: "22.治疗用一次性医用材料费不能为空", trigger: "blur" }
    ],
    d33: [
      { required: true, message: "23.手术用一次性医用材料费不能为空", trigger: "blur" }
    ],
    d34: [
      { required: true, message: "24.其他费不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询B04非中医院-补充信息（其他手术+费用+扩展信息）列表 */
const getList = async () => {
  loading.value = true;
  const res = await listNatdssB04MedicalRecordFrontSheetNonTcmSupplement(queryParams.value);
  natdssB04MedicalRecordFrontSheetNonTcmSupplementList.value = res.rows;
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
  natdssB04MedicalRecordFrontSheetNonTcmSupplementFormRef.value?.resetFields();
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
const handleSelectionChange = (selection: NatdssB04MedicalRecordFrontSheetNonTcmSupplementVO[]) => {
  ids.value = selection.map(item => item.patientId);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = "添加B04非中医院-补充信息（其他手术+费用+扩展信息）";
}

/** 修改按钮操作 */
const handleUpdate = async (row?: NatdssB04MedicalRecordFrontSheetNonTcmSupplementVO) => {
  reset();
  const _patientId = row?.patientId || ids.value[0]
  const res = await getNatdssB04MedicalRecordFrontSheetNonTcmSupplement(_patientId);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = "修改B04非中医院-补充信息（其他手术+费用+扩展信息）";
}

/** 提交按钮 */
const submitForm = () => {
  natdssB04MedicalRecordFrontSheetNonTcmSupplementFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.patientId) {
        await updateNatdssB04MedicalRecordFrontSheetNonTcmSupplement(form.value).finally(() =>  buttonLoading.value = false);
      } else {
        await addNatdssB04MedicalRecordFrontSheetNonTcmSupplement(form.value).finally(() =>  buttonLoading.value = false);
      }
      proxy?.$modal.msgSuccess("操作成功");
      dialog.visible = false;
      await getList();
    }
  });
}

/** 删除按钮操作 */
const handleDelete = async (row?: NatdssB04MedicalRecordFrontSheetNonTcmSupplementVO) => {
  const _patientIds = row?.patientId || ids.value;
  await proxy?.$modal.confirm('是否确认删除B04非中医院-补充信息（其他手术+费用+扩展信息）编号为"' + _patientIds + '"的数据项？').finally(() => loading.value = false);
  await delNatdssB04MedicalRecordFrontSheetNonTcmSupplement(_patientIds);
  proxy?.$modal.msgSuccess("删除成功");
  await getList();
}

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download('natdss/natdssB04MedicalRecordFrontSheetNonTcmSupplement/export', {
    ...queryParams.value
  }, `natdssB04MedicalRecordFrontSheetNonTcmSupplement_${new Date().getTime()}.xlsx`)
}

onMounted(() => {
  getList();
});
</script>
