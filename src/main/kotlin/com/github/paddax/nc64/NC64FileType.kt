package com.github.paddax.nc64

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object NC64FileType : LanguageFileType(NC64Language) {
    override fun getName(): String = "NC64 File"
    override fun getDescription(): String = "NC64 language file"
    override fun getDefaultExtension(): String = "nc64"
    override fun getIcon(): Icon = NC64Icons.FILE
}
