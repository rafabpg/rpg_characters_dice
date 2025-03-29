---
name: "✅ Teste de Aceitação"
about: Validar funcionalidade antes do merge
title: "QA: [NOME DA FEATURE/BUG] (PR #{{PR_NUMBER}})"
labels: "qa, needs testing"
assignees: ""
---

### 📌 **PR Vinculado**
#{{PR_NUMBER}}

### 🎯 **Critérios de Aceitação**  
_(Preenchido pelo dev)_  
- [ ] Funcionalidade conforme especificado em #{{ISSUE_ORIGINAL}}  
- [ ] Nenhuma regressão identificada  
- [ ] Documentação atualizada (se aplicável)  

### 🔍 **Passos para Testar**
1. Acessar [URL de Preview](#) _(gerada pelo GitHub Actions)_  
2. Executar cenário: [Passo a passo detalhado]  
3. Dados de teste:  
   ```json
   {"user": "test@example.com", "senha": "12345"}