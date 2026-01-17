<template>
  <div class="p-2">
    <transition :enter-active-class="proxy?.animate.searchAnimate.enter" :leave-active-class="proxy?.animate.searchAnimate.leave">
      <div v-show="showSearch" class="mb-[10px]">
        <el-card shadow="hover">
          <DynamicSearchForm
            ref="queryFormRef"
            :query="queryParams"
            :visible-fields="visibleSearchFields"
            @search="handleQuery"
            @reset="resetQuery"
          />
        </el-card>
      </div>
    </transition>

    <el-row :gutter="10">
      <!-- 左侧目录树 -->
      <!-- <el-col :span="6">
        <el-card shadow="never" class="tree-card">
          <template #header>
            <div class="flex items-center justify-between">
              <span>科室人员目录</span>
              <el-button size="small" @click="loadDeptTree">刷新</el-button>
            </div>
          </template>
          <el-tree
            ref="deptTreeRef"
            :data="deptTreeData"
            :props="treeProps"
            :expand-on-click-node="false"
            :highlight-current="true"
            @node-click="handleNodeClick"
            node-key="id"
            default-expand-all
          >
            <template #default="{ node, data }">
              <span class="flex items-center">
                <el-icon v-if="data.type === 'dept'" class="mr-1">
                  <FolderOpened v-if="node.expanded" />
                  <Folder v-else />
                </el-icon>
                <el-icon v-else class="mr-1">
                  <User />
                </el-icon>
                <span>{{ node.label }}</span>
              </span>
            </template>
          </el-tree>
        </el-card>
      </el-col> -->

      <!-- 右侧内容区域 -->
      <el-col :span="24">
        <!-- 医生详细信息 -->
        <el-card v-if="currentView === 'doctor'" shadow="never">
          <template #header>
            <div class="flex items-center justify-between">
              <span>医生详细信息 - {{ selectedDoctor?.doctorName }}</span>
            </div>
          </template>
          <div v-if="selectedDoctor" class="doctor-detail">
            <el-row :gutter="20">
              <el-col :span="8">
                <div class="detail-item">
                  <label>医生工号：</label>
                  <span>{{ selectedDoctor.doctorCode }}</span>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="detail-item">
                  <label>医生姓名：</label>
                  <span>{{ selectedDoctor.doctorName }}</span>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="detail-item">
                  <label>性别：</label>
                  <el-tag :type="selectedDoctor.gender === 1 ? 'primary' : 'success'">
                    {{ selectedDoctor.gender === 1 ? '男' : '女' }}
                  </el-tag>
                </div>
              </el-col>
            </el-row>
            <el-row :gutter="20" class="mt-4">
              <el-col :span="8">
                <div class="detail-item">
                  <label>出生日期：</label>
                  <span>{{ parseTime(selectedDoctor.birthDate, '{y}-{m}-{d}') }}</span>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="detail-item">
                  <label>职称：</label>
                  <span>{{ selectedDoctor.title }}</span>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="detail-item">
                  <label>职称级别：</label>
                  <el-tag :type="getTitleLevelType(selectedDoctor.titleLevel?.toString())">
                    {{ getTitleLevelText(selectedDoctor.titleLevel?.toString()) }}
                  </el-tag>
                </div>
              </el-col>
            </el-row>
            <el-row :gutter="20" class="mt-4">
              <el-col :span="8">
                <div class="detail-item">
                  <label>科室：</label>
                  <span>{{ selectedDoctor.departmentName }}</span>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="detail-item">
                  <label>联系电话：</label>
                  <span>{{ selectedDoctor.phone }}</span>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="detail-item">
                  <label>电子邮箱：</label>
                  <span>{{ selectedDoctor.email }}</span>
                </div>
              </el-col>
            </el-row>
            <el-row :gutter="20" class="mt-4">
              <el-col :span="8">
                <div class="detail-item">
                  <label>入职日期：</label>
                  <span>{{ parseTime(selectedDoctor.entryDate, '{y}-{m}-{d}') }}</span>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="detail-item">
                  <label>状态：</label>
                  <el-tag :type="getStatusType(selectedDoctor.status?.toString())">
                    {{ getStatusText(selectedDoctor.status?.toString()) }}
                  </el-tag>
                </div>
              </el-col>
              <el-col :span="8">
                <div class="detail-item">
                  <label>身份证号：</label>
                  <span>{{ selectedDoctor.idCard }}</span>
                </div>
              </el-col>
            </el-row>
          </div>

          <!-- 医生考评信息 -->
          <el-card shadow="never" class="mt-4">
            <template #header>
              <span>医生考评记录</span>
            </template>
            <el-table :data="doctorEvaluations" border style="width: 100%">
              <el-table-column prop="doctorName" label="医生姓名" width="100" align="center"></el-table-column>
              <el-table-column prop="evaluationYear" label="考评年度" width="100" align="center"></el-table-column>
              <el-table-column prop="evaluationPeriod" label="考评周期" width="100" align="center"></el-table-column>
              <el-table-column prop="selfScore" label="自评得分" width="100" align="center"></el-table-column>
              <el-table-column prop="peerScore" label="同行评议得分" width="120" align="center"></el-table-column>
              <el-table-column prop="patientScore" label="患者评价得分" width="120" align="center"></el-table-column>
              <el-table-column prop="deptScore" label="科室评价得分" width="120" align="center"></el-table-column>
              <el-table-column prop="hospitalScore" label="医院评价得分" width="120" align="center"></el-table-column>
              <el-table-column prop="totalScore" label="总分" width="80" align="center"></el-table-column>
              <el-table-column prop="evaluationResult" label="考评结果" width="100" align="center"></el-table-column>
              <el-table-column prop="rewardPunishment" label="奖惩情况" width="100" align="center"></el-table-column>
              <el-table-column prop="evaluationOpinion" label="考评意见" width="100" align="center"></el-table-column>
              <el-table-column label="操作" width="80" align="center">
                <template #default="scope">
                  <el-button link size="small">查看</el-button>
                </template>
              </el-table-column>
            </el-table>
          </el-card>
          <div v-if="doctorWorkExperiences.length > 0" class="mt-6">
            <el-divider>工作经历</el-divider>
            <div v-for="(experience, index) in doctorWorkExperiences" :key="index" class="mb-4">
              <el-card shadow="hover">
                <div>
                  <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 8px">
                    <h4 style="margin: 0; font-weight: 600; color: #409eff; font-size: 16px">{{ experience.organization }}</h4>
                    <el-tag type="info">{{ formatTimeRange(experience.startDate, experience.endDate) }}</el-tag>
                  </div>
                  <p style="margin: 4px 0; color: #606266"><strong>职位：</strong>{{ experience.position }}</p>
                  <p v-if="experience.jobDescription" style="margin: 4px 0; color: #606266">
                    <strong>工作内容：</strong>{{ experience.jobDescription }}
                  </p>
                </div>
              </el-card>
            </div>
          </div>

          <!-- 教育经历 -->
          <div v-if="doctorEducations.length > 0" class="mt-6">
            <el-divider>教育经历</el-divider>
            <div v-for="(education, index) in doctorEducations" :key="index" class="mb-4">
              <el-card shadow="hover">
                <div>
                  <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 8px">
                    <h4 style="margin: 0; font-weight: 600; color: #409eff; font-size: 16px">{{ education.schoolName }}</h4>
                    <el-tag type="success">{{ formatTimeRange(education.startDate, education.endDate) }}</el-tag>
                  </div>
                  <el-row :gutter="20">
                    <el-col :span="12">
                      <p style="margin: 4px 0; color: #606266"><strong>专业：</strong>{{ education.major }}</p>
                    </el-col>
                    <el-col :span="12">
                      <p style="margin: 4px 0; color: #606266"><strong>学历：</strong>{{ education.degree }}</p>
                    </el-col>
                  </el-row>
                  <p v-if="education.remark" style="margin: 4px 0; color: #606266"><strong>备注：</strong>{{ education.remark }}</p>
                </div>
              </el-card>
            </div>
          </div>

          <!-- 培训信息 -->
          <div v-if="doctorTrainings.length > 0" class="mt-6">
            <el-divider>培训信息</el-divider>
            <div v-for="(training, index) in doctorTrainings" :key="index" class="mb-4">
              <el-card shadow="hover">
                <div>
                  <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 8px">
                    <h4 style="margin: 0; font-weight: 600; color: #409eff; font-size: 16px">{{ training.trainingName }}</h4>
                    <el-tag type="warning">{{ formatTimeRange(training.startDate, training.endDate) }}</el-tag>
                  </div>
                  <el-row :gutter="20">
                    <el-col :span="8">
                      <p style="margin: 4px 0; color: #606266"><strong>培训类型：</strong>{{ training.trainingType }}</p>
                    </el-col>
                    <el-col :span="8">
                      <p style="margin: 4px 0; color: #606266"><strong>培训单位：</strong>{{ training.trainingUnit }}</p>
                    </el-col>
                    <el-col :span="8">
                      <p v-if="training.trainingHours" style="margin: 4px 0; color: #606266">
                        <strong>培训学时：</strong>{{ training.trainingHours }} 学时
                      </p>
                    </el-col>
                  </el-row>
                  <p v-if="training.trainingContent" style="margin: 4px 0; color: #606266">
                    <strong>培训内容：</strong>{{ training.trainingContent }}
                  </p>
                </div>
              </el-card>
            </div>
          </div>

          <!-- 荣誉信息 -->
          <div v-if="doctorHonors.length > 0" class="mt-6">
            <el-divider>荣誉信息</el-divider>
            <div v-for="(honor, index) in doctorHonors" :key="index" class="mb-4">
              <el-card shadow="hover">
                <div>
                  <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 8px">
                    <h4 style="margin: 0; font-weight: 600; color: #409eff; font-size: 16px">{{ honor.honorName }}</h4>
                    <el-tag type="danger">{{ honor.honorLevel }}</el-tag>
                  </div>
                  <el-row :gutter="20">
                    <el-col :span="12">
                      <p style="margin: 4px 0; color: #606266"><strong>授予单位：</strong>{{ honor.awardUnit }}</p>
                    </el-col>
                    <el-col :span="12">
                      <p style="margin: 4px 0; color: #606266"><strong>获得日期：</strong>{{ parseTime(honor.awardDate, '{y}-{m}-{d}') }}</p>
                    </el-col>
                  </el-row>
                  <p v-if="honor.certificateNo" style="margin: 4px 0; color: #606266"><strong>证书编号：</strong>{{ honor.certificateNo }}</p>
                  <p v-if="honor.remark" style="margin: 4px 0; color: #606266"><strong>备注：</strong>{{ honor.remark }}</p>
                </div>
              </el-card>
            </div>
          </div>

          <!-- 论文信息 -->
          <div v-if="doctorPublications.length > 0" class="mt-6">
            <el-divider>论文信息</el-divider>
            <div v-for="(publication, index) in doctorPublications" :key="index" class="mb-4">
              <el-card shadow="hover">
                <div>
                  <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 8px">
                    <h4 style="margin: 0; font-weight: 600; color: #409eff; font-size: 16px">{{ publication.title }}</h4>
                    <el-tag type="info">{{ publication.publicationType }}</el-tag>
                  </div>
                  <el-row :gutter="20" class="mb-2">
                    <el-col :span="8">
                      <p style="margin: 4px 0; color: #606266"><strong>作者：</strong>{{ publication.authors }}</p>
                    </el-col>
                    <el-col :span="8">
                      <p v-if="publication.authorOrder" style="margin: 4px 0; color: #606266">
                        <strong>作者排序：</strong>{{ publication.authorOrder }}
                      </p>
                    </el-col>
                    <el-col :span="8">
                      <p style="margin: 4px 0; color: #606266"><strong>期刊/出版社：</strong>{{ publication.journalName }}</p>
                    </el-col>
                  </el-row>
                  <el-row :gutter="20">
                    <el-col :span="8">
                      <p style="margin: 4px 0; color: #606266"><strong>发表日期：</strong>{{ parseTime(publication.publishDate, '{y}-{m}-{d}') }}</p>
                    </el-col>
                    <el-col :span="8">
                      <p v-if="publication.volume" style="margin: 4px 0; color: #606266"><strong>卷号：</strong>{{ publication.volume }}</p>
                    </el-col>
                    <el-col :span="8">
                      <p v-if="publication.issue" style="margin: 4px 0; color: #606266"><strong>期号：</strong>{{ publication.issue }}</p>
                    </el-col>
                  </el-row>
                </div>
              </el-card>
            </div>
          </div>

          <!-- 科研项目信息 -->
          <div v-if="doctorResearchProjects.length > 0" class="mt-6">
            <el-divider>科研项目信息</el-divider>
            <div v-for="(project, index) in doctorResearchProjects" :key="index" class="mb-4">
              <el-card shadow="hover">
                <div>
                  <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 8px">
                    <h4 style="margin: 0; font-weight: 600; color: #409eff; font-size: 16px">{{ project.projectName }}</h4>
                    <el-tag type="success">{{ project.projectLevel }}</el-tag>
                  </div>
                  <el-row :gutter="20" class="mb-2">
                    <el-col :span="8">
                      <p v-if="project.projectNo" style="margin: 4px 0; color: #606266"><strong>项目编号：</strong>{{ project.projectNo }}</p>
                    </el-col>
                    <el-col :span="8">
                      <p style="margin: 4px 0; color: #606266"><strong>项目类型：</strong>{{ project.projectType }}</p>
                    </el-col>
                    <el-col :span="8">
                      <p style="margin: 4px 0; color: #606266"><strong>承担角色：</strong>{{ project.role }}</p>
                    </el-col>
                  </el-row>
                  <el-row :gutter="20">
                    <el-col :span="12">
                      <p style="margin: 4px 0; color: #606266">
                        <strong>项目周期：</strong>{{ formatTimeRange(project.startDate, project.endDate) }}
                      </p>
                    </el-col>
                    <el-col :span="12">
                      <p v-if="project.fundingAmount" style="margin: 4px 0; color: #606266">
                        <strong>资助金额：</strong>{{ project.fundingAmount }} 元
                      </p>
                    </el-col>
                  </el-row>
                </div>
              </el-card>
            </div>
          </div>

          <!-- 学术任职信息 -->
          <div v-if="doctorAcademicPositions.length > 0" class="mt-6">
            <el-divider>学术任职信息</el-divider>
            <div v-for="(position, index) in doctorAcademicPositions" :key="index" class="mb-4">
              <el-card shadow="hover">
                <div>
                  <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 8px">
                    <h4 style="margin: 0; font-weight: 600; color: #409eff; font-size: 16px">{{ position.organization }}</h4>
                    <el-tag type="primary">{{ position.isCurrent === 1 ? '现任' : '历任' }}</el-tag>
                  </div>
                  <el-row :gutter="20" class="mb-2">
                    <el-col :span="8">
                      <p style="margin: 4px 0; color: #606266"><strong>职务：</strong>{{ position.position }}</p>
                    </el-col>
                    <el-col :span="8">
                      <p v-if="position.positionLevel" style="margin: 4px 0; color: #606266">
                        <strong>职务级别：</strong>{{ position.positionLevel }}
                      </p>
                    </el-col>
                    <el-col :span="8">
                      <p style="margin: 4px 0; color: #606266">
                        <strong>任职周期：</strong>{{ formatTimeRange(position.startDate, position.endDate) }}
                      </p>
                    </el-col>
                  </el-row>
                  <p v-if="position.remark" style="margin: 4px 0; color: #606266"><strong>备注：</strong>{{ position.remark }}</p>
                </div>
              </el-card>
            </div>
          </div>
        </el-card>

        <!-- 科室医生列表 -->
        <el-card v-else-if="currentView === 'dept'" shadow="never">
          <template #header>
            <el-row :gutter="10" class="mb8">
              <el-col :span="1.5">
                <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['doctor:doctorInfo:export']">导出</el-button>
              </el-col>
              <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
            </el-row>
          </template>

          <el-table v-loading="loading" border :data="doctorBasicInfoList" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55" align="center" />
            <el-table-column
              v-for="field in visibleColumns"
              :key="field.prop"
              :label="field.label"
              align="center"
              :prop="field.prop"
              :width="field.width || undefined"
            >
              <template
                #default="scope"
                v-if="field.prop === 'birthDate' || field.prop === 'entryDate' || field.prop === 'createTime' || field.prop === 'updateTime'"
              >
                <span>{{ parseTime(scope.row[field.prop], '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
              </template>
              <template #default="scope" v-else-if="field.prop === 'gender'">
                <el-tag :type="scope.row[field.prop] === '1' ? 'primary' : 'success'">
                  {{ scope.row[field.prop] === '1' ? '男' : '女' }}
                </el-tag>
              </template>
              <template #default="scope" v-else-if="field.prop === 'titleLevel'">
                <el-tag :type="getTitleLevelType(scope.row[field.prop])">
                  {{ getTitleLevelText(scope.row[field.prop]) }}
                </el-tag>
              </template>
              <template #default="scope" v-else-if="field.prop === 'status'">
                <el-tag :type="getStatusType(scope.row[field.prop])">
                  {{ getStatusText(scope.row[field.prop]) }}
                </el-tag>
              </template>
              <template #default="scope" v-else-if="field.prop === 'delFlag'">
                <el-tag :type="scope.row[field.prop] === '0' ? 'success' : 'danger'">
                  {{ scope.row[field.prop] === '0' ? '否' : '是' }}
                </el-tag>
              </template>
              <template #default="scope" v-else>
                {{ scope.row[field.prop] }}
              </template>
            </el-table-column>
            <el-table-column label="操作" width="120" align="center">
              <template #default="scope">
                <el-button link size="small" @click="handleViewArchive(scope.row)">查看档案</el-button>
              </template>
            </el-table-column>
          </el-table>

          <pagination
            v-show="total > 0"
            :total="total"
            v-model:page="queryParams.pageNum"
            v-model:limit="queryParams.pageSize"
            @pagination="getList"
          />
        </el-card>

        <!-- 默认显示全部医生列表 -->
        <el-card v-else shadow="never">
          <template #header>
            <el-row :gutter="10" class="mb8">
              <el-col :span="1.5">
                <el-button type="warning" plain icon="Download" @click="handleExport" v-hasPermi="['doctor:doctorInfo:export']">导出</el-button>
              </el-col>
              <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
            </el-row>
          </template>

          <el-table v-loading="loading" border :data="doctorBasicInfoList" @selection-change="handleSelectionChange">
            <el-table-column type="selection" width="55" align="center" />
            <el-table-column
              v-for="field in visibleColumns"
              :key="field.prop"
              :label="field.label"
              align="center"
              :prop="field.prop"
              :width="field.width || undefined"
            >
              <template
                #default="scope"
                v-if="field.prop === 'birthDate' || field.prop === 'entryDate' || field.prop === 'createTime' || field.prop === 'updateTime'"
              >
                <span>{{ parseTime(scope.row[field.prop], '{y}-{m}-{d} {h}:{i}:{s}') }}</span>
              </template>
              <template #default="scope" v-else-if="field.prop === 'gender'">
                <el-tag :type="scope.row[field.prop] === '1' ? 'primary' : 'success'">
                  {{ scope.row[field.prop] === '1' ? '男' : '女' }}
                </el-tag>
              </template>
              <template #default="scope" v-else-if="field.prop === 'titleLevel'">
                <el-tag :type="getTitleLevelType(scope.row[field.prop])">
                  {{ getTitleLevelText(scope.row[field.prop]) }}
                </el-tag>
              </template>
              <template #default="scope" v-else-if="field.prop === 'status'">
                <el-tag :type="getStatusType(scope.row[field.prop])">
                  {{ getStatusText(scope.row[field.prop]) }}
                </el-tag>
              </template>
              <template #default="scope" v-else-if="field.prop === 'delFlag'">
                <el-tag :type="scope.row[field.prop] === '0' ? 'success' : 'danger'">
                  {{ scope.row[field.prop] === '0' ? '否' : '是' }}
                </el-tag>
              </template>
              <template #default="scope" v-else>
                {{ scope.row[field.prop] }}
              </template>
            </el-table-column>
            <el-table-column label="操作" width="120" align="center">
              <template #default="scope">
                <el-button link size="small" @click="handleViewArchive(scope.row)">查看档案</el-button>
              </template>
            </el-table-column>
          </el-table>

          <pagination
            v-show="total > 0"
            :total="total"
            v-model:page="queryParams.pageNum"
            v-model:limit="queryParams.pageSize"
            @pagination="getList"
          />
        </el-card>
      </el-col>
    </el-row>
    <!-- 添加或修改医师基本信息对话框 -->
    <el-dialog :title="dialog.title" v-model="dialog.visible" width="500px" append-to-body>
      <el-form ref="doctorBasicInfoFormRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="医生工号" prop="doctorCode">
          <el-input v-model="form.doctorCode" placeholder="请输入医生工号" />
        </el-form-item>
        <el-form-item label="医生姓名" prop="doctorName">
          <el-input v-model="form.doctorName" placeholder="请输入医生姓名" />
        </el-form-item>
        <el-form-item label="性别 1-男 2-女" prop="gender">
          <el-input v-model="form.gender" placeholder="请输入性别 1-男 2-女" />
        </el-form-item>
        <el-form-item label="出生日期" prop="birthDate">
          <el-date-picker clearable v-model="form.birthDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择出生日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="身份证号" prop="idCard">
          <el-input v-model="form.idCard" placeholder="请输入身份证号" />
        </el-form-item>
        <el-form-item label="联系电话" prop="phone">
          <el-input v-model="form.phone" placeholder="请输入联系电话" />
        </el-form-item>
        <el-form-item label="电子邮箱" prop="email">
          <el-input v-model="form.email" placeholder="请输入电子邮箱" />
        </el-form-item>
        <el-form-item label="照片URL" prop="photoUrl">
          <el-input v-model="form.photoUrl" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="科室ID" prop="deptId">
          <el-input v-model="form.deptId" placeholder="请输入科室ID" />
        </el-form-item>
        <el-form-item label="科室名称" prop="departmentName">
          <el-input v-model="form.departmentName" placeholder="请输入科室名称" />
        </el-form-item>
        <el-form-item label="职称" prop="title">
          <el-input v-model="form.title" placeholder="请输入职称" />
        </el-form-item>
        <el-form-item label="职称级别 1-初级 2-中级 3-副高 4-正高" prop="titleLevel">
          <el-input v-model="form.titleLevel" placeholder="请输入职称级别 1-初级 2-中级 3-副高 4-正高" />
        </el-form-item>
        <el-form-item label="入职日期" prop="entryDate">
          <el-date-picker clearable v-model="form.entryDate" type="datetime" value-format="YYYY-MM-DD HH:mm:ss" placeholder="请选择入职日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="是否删除 0-否 1-是" prop="delFlag">
          <el-input v-model="form.delFlag" placeholder="请输入是否删除 0-否 1-是" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button :loading="buttonLoading" type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>

    <!-- 字段配置对话框 -->
    <FieldConfigDialog v-model:visible="showFieldConfig" :field-config-manager="fieldConfigManager" @confirm="handleFieldConfigConfirm" />
    <SearchConfigDialog v-model="searchConfigVisible" :search-config-manager="searchConfigManager" @confirm="handleSearchConfigConfirm" />
  </div>
</template>

<script setup name="DoctorBasicInfo" lang="ts">
import { listDoctorBasicInfo, getDoctorBasicInfo, delDoctorBasicInfo, addDoctorBasicInfo, updateDoctorBasicInfo } from '@/api/doctor/doctorBasicInfo';
import { DoctorBasicInfoVO, DoctorBasicInfoQuery, DoctorBasicInfoForm } from '@/api/doctor/doctorBasicInfo/types';
import { createDoctorInfoFieldConfig } from '@/utils/configs/doctor/doctorFieldConfigs';
import { FieldConfigManager } from '@/utils/configs/fieldConfigManager';
import FieldConfigDialog from '@/components/FieldConfigDialog.vue';
import DynamicSearchForm from '@/components/DynamicSearchForm.vue';
import SearchConfigDialog from '@/components/SearchConfigDialog.vue';
import { createDoctorBasicInfoSearchConfig } from '@/utils/configs/doctor/doctorSearchConfigs';
import { SearchConfigManager } from '@/utils/configs/searchConfigManager';
import { parseTime } from '@/utils/ruoyi';
import type { FormInstance } from 'element-plus';
import type { DialogOption, PageData } from '@/types/global';
import type { ComponentInternalInstance } from 'vue';
import * as echarts from 'echarts';
import { Folder, FolderOpened, User } from '@element-plus/icons-vue';
import { listDept } from '@/api/system/dept';
import type { DeptVO } from '@/api/system/dept/types';
import { listDoctorWorkExperience } from '@/api/doctor/doctorWorkExperience';
import { listDoctorEducation } from '@/api/doctor/doctorEducation';
import { listDoctorTraining } from '@/api/doctor/doctorTraining';
import { listDoctorHonor } from '@/api/doctor/doctorHonor';
import { listDoctorPublication } from '@/api/doctor/doctorPublication';
import { listDoctorResearchProject } from '@/api/doctor/doctorResearchProject';
import { listDoctorAcademicPosition } from '@/api/doctor/doctorAcademicPosition';
import type { DoctorWorkExperienceVO } from '@/api/doctor/doctorWorkExperience/types';
import type { DoctorEducationVO } from '@/api/doctor/doctorEducation/types';
import type { DoctorTrainingVO } from '@/api/doctor/doctorTraining/types';
import type { DoctorHonorVO } from '@/api/doctor/doctorHonor/types';
import type { DoctorPublicationVO } from '@/api/doctor/doctorPublication/types';
import type { DoctorResearchProjectVO } from '@/api/doctor/doctorResearchProject/types';
import type { DoctorAcademicPositionVO } from '@/api/doctor/doctorAcademicPosition/types';
import type { DoctorEvaluationVO } from '@/api/doctor/doctorBasicInfo/types';

const { proxy } = getCurrentInstance() as ComponentInternalInstance;

const doctorBasicInfoList = ref<DoctorBasicInfoVO[]>([]);
const buttonLoading = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref<Array<string | number>>([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);

const queryFormRef = ref<FormInstance>();
const doctorBasicInfoFormRef = ref<FormInstance>();
const deptTreeRef = ref();

const dialog = reactive<DialogOption>({
  visible: false,
  title: ''
});

// 字段配置相关变量
const fieldConfigManager = createDoctorInfoFieldConfig();

// 初始化时清除之前的字段配置和localStorage缓存，确保新配置生效
fieldConfigManager.clearConfig();
localStorage.removeItem('doctorBasicInfo_field_config');
const showFieldConfig = ref(false);
const searchFieldGroups = createDoctorInfoSearchConfig();
const searchConfigManager = new SearchConfigManager('doctorInfo', searchFieldGroups);

// 初始化时清除之前的搜索配置和localStorage缓存，确保新配置生效
searchConfigManager.clearConfig();
localStorage.removeItem('doctorInfo_search_config');

const searchConfigVisible = ref(false);
const visibleSearchFields = computed(() => searchConfigManager.getVisibleFields());

// 目录树相关变量
const deptTreeData = ref<any[]>([]);
const currentView = ref<'all' | 'dept' | 'doctor'>('all');
const selectedDept = ref<DeptVO | null>(null);
const selectedDoctor = ref<DoctorBasicInfoVO | null>(null);
const doctorWorkExperiences = ref<DoctorWorkExperienceVO[]>([]);
const doctorEducations = ref<DoctorEducationVO[]>([]);
const doctorTrainings = ref<DoctorTrainingVO[]>([]);
const doctorHonors = ref<DoctorHonorVO[]>([]);
const doctorPublications = ref<DoctorPublicationVO[]>([]);
const doctorResearchProjects = ref<DoctorResearchProjectVO[]>([]);
const doctorAcademicPositions = ref<DoctorAcademicPositionVO[]>([]);
const doctorEvaluations = ref<DoctorEvaluationVO[]>([]);

// 树形结构配置
const treeProps = {
  children: 'children',
  label: 'label'
};

// 计算属性：可见列
const visibleColumns = computed(() => fieldConfigManager.getVisibleFields());

const initFormData: DoctorBasicInfoForm = {
  id: undefined,
  doctorCode: undefined,
  doctorName: undefined,
  gender: undefined,
  birthDate: undefined,
  idCard: undefined,
  phone: undefined,
  email: undefined,
  photoUrl: undefined,
  deptId: undefined,
  departmentName: undefined,
  title: undefined,
  titleLevel: undefined,
  status: undefined,
  entryDate: undefined,
  delFlag: undefined,
  tenantId: undefined
};
const data = reactive<PageData<DoctorBasicInfoForm, DoctorBasicInfoQuery>>({
  form: { ...initFormData },
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    doctorCode: undefined,
    doctorName: undefined,
    gender: undefined,
    birthDate: undefined,
    idCard: undefined,
    phone: undefined,
    email: undefined,
    photoUrl: undefined,
    deptId: undefined,
    departmentName: undefined,
    title: undefined,
    titleLevel: undefined,
    status: undefined,
    entryDate: undefined,
    delFlag: undefined,
    params: {}
  },
  rules: {
    id: [{ required: true, message: '主键ID不能为空', trigger: 'blur' }],
    doctorCode: [{ required: true, message: '医生工号不能为空', trigger: 'blur' }],
    doctorName: [{ required: true, message: '医生姓名不能为空', trigger: 'blur' }]
  }
});

const { queryParams, form, rules } = toRefs(data);

// 辅助方法：获取职称级别类型
const getTitleLevelType = (level: string) => {
  const types = { '1': 'info', '2': 'success', '3': 'warning', '4': 'danger' };
  return types[level] || 'info';
};

// 辅助方法：获取职称级别文本
const getTitleLevelText = (level: string) => {
  const texts = { '1': '初级', '2': '中级', '3': '副高', '4': '正高' };
  return texts[level] || level;
};

// 辅助方法：获取状态类型
const getStatusType = (status: string) => {
  const types = { '1': 'success', '2': 'warning', '3': 'info' };
  return types[status] || 'info';
};

// 辅助方法：获取状态文本
const getStatusText = (status: string) => {
  const texts = { '1': '正常', '2': '停用', '3': '离职' };
  return texts[status] || status;
};

// 辅助方法：格式化时间范围
const formatTimeRange = (startDate: string, endDate?: string) => {
  const start = parseTime(startDate, '{y}-{m}-{d}');
  const end = endDate ? parseTime(endDate, '{y}-{m}-{d}') : '至今';
  return `${start} 至 ${end}`;
};

/** 查询医师基本信息列表 */
const getList = async () => {
  loading.value = true;
  try {
    const res = await listDoctorBasicInfo(queryParams.value);
    doctorBasicInfoList.value = res.rows;
    total.value = res.total;
  } catch (error) {
    console.error('获取医生列表失败:', error);
  } finally {
    loading.value = false;
  }
};

/** 取消按钮 */
const cancel = () => {
  reset();
  dialog.visible = false;
};

/** 表单重置 */
const reset = () => {
  form.value = { ...initFormData };
  doctorBasicInfoFormRef.value?.resetFields();
};

/** 搜索按钮操作 */
const handleQuery = () => {
  // 处理daterange字段
  if (queryParams.entryDate && Array.isArray(queryParams.entryDate)) {
    queryParams.entryDateStart = queryParams.entryDate[0];
    queryParams.entryDateEnd = queryParams.entryDate[1];
  } else {
    queryParams.entryDateStart = undefined;
    queryParams.entryDateEnd = undefined;
  }

  if (queryParams.birthDate && Array.isArray(queryParams.birthDate)) {
    queryParams.birthDateStart = queryParams.birthDate[0];
    queryParams.birthDateEnd = queryParams.birthDate[1];
  } else {
    queryParams.birthDateStart = undefined;
    queryParams.birthDateEnd = undefined;
  }

  if (queryParams.graduationDate && Array.isArray(queryParams.graduationDate)) {
    queryParams.graduationDateStart = queryParams.graduationDate[0];
    queryParams.graduationDateEnd = queryParams.graduationDate[1];
  } else {
    queryParams.graduationDateStart = undefined;
    queryParams.graduationDateEnd = undefined;
  }

  queryParams.pageNum = 1;
  getList();
};

/** 重置按钮操作 */
const resetQuery = () => {
  queryFormRef.value?.resetFields();
  handleQuery();
};

/** 多选框选中数据 */
const handleSelectionChange = (selection: DoctorBasicInfoVO[]) => {
  ids.value = selection.map((item) => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
};

/** 新增按钮操作 */
const handleAdd = () => {
  reset();
  dialog.visible = true;
  dialog.title = '添加医师基本信息';
};

/** 修改按钮操作 */
const handleUpdate = async (row?: DoctorBasicInfoVO) => {
  reset();
  const _id = row?.id || ids.value[0];
  const res = await getDoctorBasicInfo(_id);
  Object.assign(form.value, res.data);
  dialog.visible = true;
  dialog.title = '修改医师基本信息';
};

/** 提交按钮 */
const submitForm = () => {
  doctorBasicInfoFormRef.value?.validate(async (valid: boolean) => {
    if (valid) {
      buttonLoading.value = true;
      if (form.value.id) {
        await updateDoctorBasicInfo(form.value).finally(() => (buttonLoading.value = false));
      } else {
        await addDoctorBasicInfo(form.value).finally(() => (buttonLoading.value = false));
      }
      proxy?.$modal.msgSuccess('操作成功');
      dialog.visible = false;
      await getList();
    }
  });
};

/** 删除按钮操作 */
const handleDelete = async (row?: DoctorBasicInfoVO) => {
  const _ids = row?.id || ids.value;
  await proxy?.$modal.confirm('是否确认删除医师基本信息编号为"' + _ids + '"的数据项？').finally(() => (loading.value = false));
  await delDoctorBasicInfo(_ids);
  proxy?.$modal.msgSuccess('删除成功');
  await getList();
};

/** 导出按钮操作 */
const handleExport = () => {
  proxy?.download(
    'system/doctorInfo/export',
    {
      ...queryParams.value
    },
    `doctorInfo_${new Date().getTime()}.xlsx`
  );
};

/** 查看档案按钮操作 */
const handleViewArchive = (row: DoctorBasicInfoVO) => {
  const { $router } = proxy!;
  $router.push({
    path: '/docktor/doctorInfo/archive',
    query: { doctorId: row.id }
  });
};

/** 字段配置按钮操作 */
const handleFieldConfig = () => {
  showFieldConfig.value = true;
};

/** 字段配置确认操作 */
const handleFieldConfigConfirm = () => {
  showFieldConfig.value = false;
};

const handleSearchConfig = () => {
  searchConfigVisible.value = true;
};
const handleSearchConfigConfirm = () => {
  searchConfigVisible.value = false;
};

/** 重置字段配置 */
const handleFieldConfigReset = () => {
  fieldConfigManager.clearConfig();
  // 同时清除localStorage中的缓存
  localStorage.removeItem('doctorBasicInfo_field_config');
  proxy?.$modal.msgSuccess('字段配置已重置，请刷新页面');
};

/** 加载科室树形数据 */
const loadDeptTree = async () => {
  try {
    console.log('开始加载科室树形数据');
    const deptRes = await listDept();
    const doctorRes = await listDoctorBasicInfo({ pageNum: 1, pageSize: 1000 }); // 获取所有医生数据

    console.log('科室数据:', deptRes);
    console.log('医生数据:', doctorRes);

    // 构建树形结构
    const deptMap = new Map();
    const treeData: any[] = [];

    // 首先收集所有有医生的科室ID
    const deptWithDoctors = new Set<number>();
    if (doctorRes && doctorRes.rows && Array.isArray(doctorRes.rows)) {
      doctorRes.rows.forEach((doctor: DoctorBasicInfoVO) => {
        if (doctor.deptId) {
          deptWithDoctors.add(Number(doctor.deptId));
        }
      });
    }

    // 处理科室数据，只处理有医生的科室
    if (deptRes && deptRes.data && Array.isArray(deptRes.data)) {
      // 首先创建有医生的科室节点
      deptRes.data.forEach((dept: DeptVO) => {
        if (deptWithDoctors.has(Number(dept.deptId))) {
          deptMap.set(dept.deptId, {
            id: `dept_${dept.deptId}`,
            label: dept.deptName,
            type: 'dept',
            deptId: dept.deptId,
            deptName: dept.deptName,
            parentId: dept.parentId,
            children: []
          });
        }
      });

      // 构建树形结构，只包含有医生的科室
      deptRes.data.forEach((dept: DeptVO) => {
        if (deptWithDoctors.has(Number(dept.deptId))) {
          const node = deptMap.get(dept.deptId);
          if (dept.parentId && deptMap.has(dept.parentId)) {
            // 有父节点，添加到父节点的children中
            const parentNode = deptMap.get(dept.parentId);
            parentNode.children.push(node);
          } else {
            // 没有父节点或父节点不存在，作为根节点
            treeData.push(node);
          }
        }
      });
    } else {
      console.warn('科室数据格式不正确:', deptRes);
    }

    // 处理医生数据，按科室分组
    if (doctorRes && doctorRes.rows && Array.isArray(doctorRes.rows)) {
      doctorRes.rows.forEach((doctor: DoctorBasicInfoVO) => {
        const deptId = doctor.deptId;
        if (deptId && deptMap.has(deptId)) {
          const deptNode = deptMap.get(deptId);
          deptNode.children.push({
            id: `doctor_${doctor.id}`,
            label: doctor.doctorName,
            type: 'doctor',
            doctorId: doctor.id,
            doctorData: doctor
          });
        }
      });
    } else {
      console.warn('医生数据格式不正确:', doctorRes);
    }

    console.log('构建的树形数据:', treeData);
    deptTreeData.value = treeData;
  } catch (error) {
    console.error('加载科室树形数据失败:', error);
    proxy?.$modal.msgError('加载科室数据失败');
  }
};

/** 加载医生工作经历 */
const loadDoctorWorkExperiences = async (doctorId: string | number) => {
  try {
    const res = await listDoctorWorkExperience({ pageNum: 1, pageSize: 1000, doctorId: Number(doctorId) });
    doctorWorkExperiences.value = res.rows || [];
  } catch (error) {
    console.error('加载医生工作经历失败:', error);
    doctorWorkExperiences.value = [];
  }
};

/** 加载医生教育经历 */
const loadDoctorEducations = async (doctorId: string | number) => {
  try {
    const res = await listDoctorEducation({ pageNum: 1, pageSize: 1000, doctorId: Number(doctorId) });
    doctorEducations.value = res.rows || [];
  } catch (error) {
    console.error('加载医生教育经历失败:', error);
    doctorEducations.value = [];
  }
};

/** 加载医生培训信息 */
const loadDoctorTrainings = async (doctorId: string | number) => {
  try {
    const res = await listDoctorTraining({ pageNum: 1, pageSize: 1000, doctorId: Number(doctorId) });
    doctorTrainings.value = res.rows || [];
  } catch (error) {
    console.error('加载医生培训信息失败:', error);
    doctorTrainings.value = [];
  }
};

/** 加载医生荣誉信息 */
const loadDoctorHonors = async (doctorId: string | number) => {
  try {
    const res = await listDoctorHonor({ pageNum: 1, pageSize: 1000, doctorId: Number(doctorId) });
    doctorHonors.value = res.rows || [];
  } catch (error) {
    console.error('加载医生荣誉信息失败:', error);
    doctorHonors.value = [];
  }
};

/** 加载医生论文信息 */
const loadDoctorPublications = async (doctorId: string | number) => {
  try {
    const res = await listDoctorPublication({ pageNum: 1, pageSize: 1000, doctorId: Number(doctorId) });
    doctorPublications.value = res.rows || [];
  } catch (error) {
    console.error('加载医生论文信息失败:', error);
    doctorPublications.value = [];
  }
};

/** 加载医生科研项目信息 */
const loadDoctorResearchProjects = async (doctorId: string | number) => {
  try {
    const res = await listDoctorResearchProject({ pageNum: 1, pageSize: 1000, doctorId: Number(doctorId) });
    doctorResearchProjects.value = res.rows || [];
  } catch (error) {
    console.error('加载医生科研项目信息失败:', error);
    doctorResearchProjects.value = [];
  }
};

/** 加载医生学术任职信息 */
const loadDoctorAcademicPositions = async (doctorId: string | number) => {
  try {
    const res = await listDoctorAcademicPosition({ pageNum: 1, pageSize: 1000, doctorId: Number(doctorId) });
    doctorAcademicPositions.value = res.rows || [];
  } catch (error) {
    console.error('加载医生学术任职信息失败:', error);
    doctorAcademicPositions.value = [];
  }
};

/** 加载医生考评信息 */
const loadDoctorEvaluations = async (doctorData: any) => {
  try {
    // 暂时使用模拟数据，实际应该调用API
    doctorEvaluations.value = [
      {
        id: 1,
        doctorId: doctorData.id,
        doctorName: doctorData.doctorName,
        evaluationYear: 2023,
        evaluationPeriod: '年度',
        selfScore: 90,
        peerScore: 99,
        patientScore: 98,
        deptScore: 81,
        hospitalScore: 96,
        totalScore: 94,
        evaluationResult: '良好',
        rewardPunishment: '',
        evaluationOpinion: ''
      },
      {
        id: 2,
        doctorId: doctorData.id,
        doctorName: doctorData.doctorName,
        evaluationYear: 2024,
        evaluationPeriod: '季度',
        selfScore: 90,
        peerScore: 98,
        patientScore: 99,
        deptScore: 87,
        hospitalScore: 91,
        totalScore: 94,
        evaluationResult: '良好',
        rewardPunishment: '',
        evaluationOpinion: ''
      },
      {
        id: 3,
        doctorId: doctorData.id,
        doctorName: doctorData.doctorName,
        evaluationYear: 2025,
        evaluationPeriod: '年度',
        selfScore: 85,
        peerScore: 82,
        patientScore: 90,
        deptScore: 91,
        hospitalScore: 92,
        totalScore: 88,
        evaluationResult: '良好',
        rewardPunishment: '',
        evaluationOpinion: ''
      },
      {
        id: 4,
        doctorId: doctorData.id,
        doctorName: doctorData.doctorName,
        evaluationYear: 2023,
        evaluationPeriod: '专项',
        selfScore: 88,
        peerScore: 93,
        patientScore: 87,
        deptScore: 96,
        hospitalScore: 84,
        totalScore: 89,
        evaluationResult: '良好',
        rewardPunishment: '',
        evaluationOpinion: ''
      },
      {
        id: 5,
        doctorId: doctorData.id,
        doctorName: doctorData.doctorName,
        evaluationYear: 2024,
        evaluationPeriod: '年度',
        selfScore: 90,
        peerScore: 99,
        patientScore: 86,
        deptScore: 83,
        hospitalScore: 83,
        totalScore: 89,
        evaluationResult: '良好',
        rewardPunishment: '',
        evaluationOpinion: ''
      },
      {
        id: 6,
        doctorId: doctorData.id,
        doctorName: doctorData.doctorName,
        evaluationYear: 2025,
        evaluationPeriod: '专项',
        selfScore: 97,
        peerScore: 83,
        patientScore: 89,
        deptScore: 90,
        hospitalScore: 90,
        totalScore: 90,
        evaluationResult: '良好',
        rewardPunishment: '',
        evaluationOpinion: ''
      }
    ];
  } catch (error) {
    console.error('加载医生考评信息失败:', error);
    doctorEvaluations.value = [];
  }
};

/** 处理树节点点击 */
const handleNodeClick = async (data: any) => {
  console.log('点击树节点:', data);

  if (data.type === 'dept') {
    // 点击科室节点，显示该科室所有医生
    console.log('点击科室节点:', data.deptName);
    currentView.value = 'dept';
    selectedDept.value = data;
    selectedDoctor.value = null;
    doctorWorkExperiences.value = [];
    doctorEducations.value = [];
    doctorTrainings.value = [];
    doctorHonors.value = [];
    doctorPublications.value = [];
    doctorResearchProjects.value = [];
    doctorAcademicPositions.value = [];
    doctorEvaluations.value = [];

    // 过滤该科室的医生
    queryParams.value.deptId = data.deptId;
    queryParams.value.pageNum = 1;
    await getList();
    console.log('科室医生列表已加载，当前视图:', currentView.value);
  } else if (data.type === 'doctor') {
    // 点击医生节点，显示医生详细信息
    console.log('点击医生节点:', data.doctorData.doctorName);
    currentView.value = 'doctor';
    selectedDoctor.value = data.doctorData;
    selectedDept.value = null;

    // 加载医生的工作经历和教育经历
    await loadDoctorWorkExperiences(data.doctorData.id);
    await loadDoctorEducations(data.doctorData.id);
    await loadDoctorTrainings(data.doctorData.id);
    await loadDoctorHonors(data.doctorData.id);
    await loadDoctorPublications(data.doctorData.id);
    await loadDoctorResearchProjects(data.doctorData.id);
    await loadDoctorAcademicPositions(data.doctorData.id);
    await loadDoctorEvaluations(data.doctorData);
    console.log('医生详细信息已加载，当前视图:', currentView.value);
  }
};

onMounted(() => {
  getList();
  loadDeptTree();
});
</script>

<style scoped>
.mt-2 {
  margin-top: 8px;
}

.tree-card {
  height: calc(100vh - 200px);
  overflow-y: auto;
}

.doctor-detail .detail-item {
  margin-bottom: 12px;
}

.doctor-detail .detail-item label {
  font-weight: bold;
  color: #606266;
  margin-right: 8px;
  min-width: 80px;
  display: inline-block;
}

.doctor-detail .detail-item span {
  color: #303133;
}

.experience-item h4,
.education-item h4 {
  margin: 0 0 8px 0;
  color: #409eff;
  font-size: 16px;
}

.experience-item p,
.education-item p {
  margin: 4px 0;
  color: #606266;
  line-height: 1.5;
}
</style>
