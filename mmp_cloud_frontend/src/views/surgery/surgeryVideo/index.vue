<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <el-form ref="queryFormRef" :model="queryParams" :inline="true">
            <el-form-item label="视频编号" prop="videoNo">
              <el-input v-model="queryParams.videoNo" placeholder="请输入视频编号" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="视频标题" prop="videoTitle">
              <el-input v-model="queryParams.videoTitle" placeholder="请输入视频标题" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="视频URL" prop="videoUrl">
              <el-input v-model="queryParams.videoUrl" placeholder="请输入视频URL" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="视频时长(秒)" prop="videoDuration">
              <el-input v-model="queryParams.videoDuration" placeholder="请输入视频时长(秒)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="视频大小(字节)" prop="videoSize">
              <el-input v-model="queryParams.videoSize" placeholder="请输入视频大小(字节)" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="视频格式" prop="videoFormat">
              <el-input v-model="queryParams.videoFormat" placeholder="请输入视频格式" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="录制设备" prop="recordingDevice">
              <el-input v-model="queryParams.recordingDevice" placeholder="请输入录制设备" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="录制医生姓名" prop="recordingDoctorName">
              <el-input v-model="queryParams.recordingDoctorName" placeholder="请输入录制医生姓名" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="上传时间" prop="uploadTime">
              <el-date-picker clearable v-model="queryParams.uploadTime" type="date" value-format="YYYY-MM-DD" placeholder="请选择上传时间" />
            </el-form-item>
            <el-form-item label="审核时间" prop="reviewTime">
              <el-date-picker clearable v-model="queryParams.reviewTime" type="date" value-format="YYYY-MM-DD" placeholder="请选择审核时间" />
            </el-form-item>
            <el-form-item label="审核意见" prop="reviewComment">
              <el-input v-model="queryParams.reviewComment" placeholder="请输入审核意见" clearable @keyup.enter="handleQuery" />
            </el-form-item>
            <el-form-item label="访问级别 internal-院内 public-公开 restricted-受限" prop="accessLevel">
              <el-input
                v-model="queryParams.accessLevel"
                placeholder="请输入访问级别 internal-院内 public-公开 restricted-受限"
                clearable
                @keyup.enter="handleQuery"
              />
            </el-form-item>
            <el-form-item label="删除标志" prop="isDeleted">
              <el-input v-model="queryParams.isDeleted" placeholder="请输入删除标志" clearable @keyup.enter="handleQuery" />
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
            <el-button type="primary" plain icon="Plus" @click="handleAdd" v-hasPermi="['system:surgeryVideo:add']">新增</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="success" plain icon="Edit" :disabled="single" @click="handleUpdate()" v-hasPermi="['system:surgeryVideo:edit']"
              >修改</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" plain icon="Delete" :disabled="multiple" @click="handleDelete()" v-hasPermi="['system:surgeryVideo:remove']"
              >删除</el-button
            >
          </el-col>
          <el-col :span="1.5">
            <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['system:surgeryVideo:export']">导出</el-button>
          </el-col>
          <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
        </el-row>
      </template>

      <el-table v-loading="loading" border :data="surgeryVideoList" @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="55" align="center" />
        <el-table-column label="主键ID" align="center" prop="id" v-if="false" />
        <el-table-column label="视频编号" align="center" prop="videoNo" />
        <el-table-column label="视频标题" align="center" prop="videoTitle" />
        <el-table-column label="视频类型 手术全程/关键步骤/教学片段" align="center" prop="videoType" />
        <el-table-column label="视频URL" align="center" prop="videoUrl" />
        <el-table-column label="视频时长(秒)" align="center" prop="videoDuration" />
        <el-table-column label="视频大小(字节)" align="center" prop="videoSize" />
        <el-table-column label="视频格式" align="center" prop="videoFormat" />
        <el-table-column label="录制设备" align="center" prop="recordingDevice" />
        <el-table-column label="录制医生姓名" align="center" prop="recordingDoctorName" />
        <el-table-column label="上传时间" align="center" prop="uploadTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.uploadTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="审核状态 pending-待审核 approved-已通过 rejected-已拒绝" align="center" prop="reviewStatus" />
        <el-table-column label="审核时间" align="center" prop="reviewTime" width="180">
          <template #default="scope">
            <span>{{ parseTime(scope.row.reviewTime, '{y}-{m}-{d}') }}</span>
          </template>
        </el-table-column>
        <el-table-column label="审核意见" align="center" prop="reviewComment" />
        <el-table-column label="访问级别 internal-院内 public-公开 restricted-受限" align="center" prop="accessLevel" />
        <el-table-column label="删除标志" align="center" prop="isDeleted" />
        <el-table-column label="操作" align="center" fixed="right" class-name="small-padding fixed-width">
          <template #default="scope">
            <el-tooltip content="修改" placement="top">
              <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['system:surgeryVideo:edit']"></el-button>
            </el-tooltip>
            <el-tooltip content="删除" placement="top">
              <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['system:surgeryVideo:remove']"></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <pagination v-show="total > 0" :total="total" v-model:page="queryParams.pageNum" v-model:limit="queryParams.pageSize" @pagination="getList" />
    </el-card>
    <!-- 添加或修改手术视频对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="surgeryVideoFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="手术记录ID" prop="surgeryRecordId">
          <el-input v-model="form.surgeryRecordId" placeholder="请输入手术记录ID" />
        </el-form-item>
        <el-form-item label="视频编号" prop="videoNo">
          <el-input v-model="form.videoNo" placeholder="请输入视频编号" />
        </el-form-item>
        <el-form-item label="视频标题" prop="videoTitle">
          <el-input v-model="form.videoTitle" placeholder="请输入视频标题" />
        </el-form-item>
        <el-form-item label="视频URL" prop="videoUrl">
          <el-input v-model="form.videoUrl" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="视频时长(秒)" prop="videoDuration">
          <el-input v-model="form.videoDuration" placeholder="请输入视频时长(秒)" />
        </el-form-item>
        <el-form-item label="视频大小(字节)" prop="videoSize">
          <el-input v-model="form.videoSize" placeholder="请输入视频大小(字节)" />
        </el-form-item>
        <el-form-item label="视频格式" prop="videoFormat">
          <el-input v-model="form.videoFormat" placeholder="请输入视频格式" />
        </el-form-item>
        <el-form-item label="录制设备" prop="recordingDevice">
          <el-input v-model="form.recordingDevice" placeholder="请输入录制设备" />
        </el-form-item>
        <el-form-item label="录制医生ID" prop="recordingDoctorId">
          <el-input v-model="form.recordingDoctorId" placeholder="请输入录制医生ID" />
        </el-form-item>
        <el-form-item label="录制医生姓名" prop="recordingDoctorName">
          <el-input v-model="form.recordingDoctorName" placeholder="请输入录制医生姓名" />
        </el-form-item>
        <el-form-item label="上传时间" prop="uploadTime">
          <el-date-picker clearable v-model="form.uploadTime" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择上传时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="审核人ID" prop="reviewerId">
          <el-input v-model="form.reviewerId" placeholder="请输入审核人ID" />
        </el-form-item>
        <el-form-item label="审核时间" prop="reviewTime">
          <el-date-picker clearable v-model="form.reviewTime" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择审核时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="审核意见" prop="reviewComment">
          <el-input v-model="form.reviewComment" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="访问级别 internal-院内 public-公开 restricted-受限" prop="accessLevel">
          <el-input v-model="form.accessLevel" placeholder="请输入访问级别 internal-院内 public-公开 restricted-受限" />
        </el-form-item>
        <el-form-item label="删除标志" prop="isDeleted">
          <el-input v-model="form.isDeleted" placeholder="请输入删除标志" />
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

<script setup name="SurgeryVideo" lang="ts">
import { listSurgeryVideo, getSurgeryVideo, delSurgeryVideo, addSurgeryVideo, updateSurgeryVideo } from '@/api/surgery/surgeryVideo';
import { SurgeryVideoVO, SurgeryVideoQuery, SurgeryVideoForm } from '@/api/surgery/surgeryVideo/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const surgeryVideoList = ref<SurgeryVideoVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<ElFormInstance>();
const surgeryVideoFormRef = ref<ElFormInstance>();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

const initFormData: SurgeryVideoForm = {
  id: undefined,
  surgeryRecordId: undefined,
  videoNo: undefined,
  videoTitle: undefined,
  videoType: undefined,
  videoUrl: undefined,
  videoDuration: undefined,
  videoSize: undefined,
  videoFormat: undefined,
  recordingDevice: undefined,
  recordingDoctorId: undefined,
  recordingDoctorName: undefined,
  uploadTime: undefined,
  reviewStatus: undefined,
  reviewerId: undefined,
  reviewTime: undefined,
  reviewComment: undefined,
  accessLevel: undefined,
  isDeleted: undefined
};
const data = reactive<PageData<SurgeryVideoForm, SurgeryVideoQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    videoNo: undefined,
    videoTitle: undefined,
    videoType: undefined,
    videoUrl: undefined,
    videoDuration: undefined,
    videoSize: undefined,
    videoFormat: undefined,
    recordingDevice: undefined,
    recordingDoctorName: undefined,
    uploadTime: undefined,
    reviewStatus: undefined,
    reviewTime: undefined,
    reviewComment: undefined,
    accessLevel: undefined,
    isDeleted: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    surgeryRecordId: [{ required: true, message: '手术记录ID不能为空', trigger: 'blur' }],
    videoNo: [{ required: true, message: '视频编号不能为空', trigger: 'blur' }],
    videoUrl: [{ required: true, message: '视频URL不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询手术视频列表 */
const getList = async () => {
  loading.value = true;
  const res = await listSurgeryVideo(queryParams.value);
  surgeryVideoList.value = res.rows;
  total.value = res.total;
  loading.value = false;
};

/** 取消按钮 */
const cancel = () => {
  reset();
  dialog.visible = false;
};

/** 表单重置 */
const reset = () => {
  form.value = { ...initFormData };
  surgeryVideoFormRef.value?.resetFields();
};

/** 搜索按钮操作 */
const handleQuery = () => {
  queryParams.value.pageNum = 1;
  getList();
};

/** 重置按钮操作 */
const resetQuery = () => {
  queryFormRef.value?.resetFields();
  handleQuery();
};

/** 多选框选中数据 */
const handleSelectionChange = (selection: SurgeryVideoVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加手术视频';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: SurgeryVideoVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getSurgeryVideo(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改手术视频';
};

/** 提交按钮 */
const submitForm = () => {
  surgeryVideoFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateSurgeryVideo(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addSurgeryVideo(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: SurgeryVideoVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除手术视频编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delSurgeryVideo(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/surgeryVideo/export',
    {
      ...queryParams.value
    },
    `surgeryVideo_${new Date().getTime()}.xlsx`
  );
};

onMounted(() => {
  getList();
});
</script>
